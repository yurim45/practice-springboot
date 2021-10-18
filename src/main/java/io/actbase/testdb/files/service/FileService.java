package io.actbase.testdb.files.service;

import com.google.common.collect.Lists;
import io.actbase.testdb.common.infra.web.storage.service.StorageService;
import io.actbase.testdb.files.domain.AttachFile;
import io.actbase.testdb.files.domain.AttachFileRepository;
import io.actbase.testdb.files.dto.FileDto;
import io.actbase.testdb.files.properties.FileProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// import io.actbase.testdb.common.infra.web.storage.service.AWSStorageService;

/**
 * The type File service.
 *
 * @author eomjeongjae
 * @since 2019 /10/15
 */
@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FileService {

  private final AttachFileRepository attachFileRepository;
  private final StorageService storageService;
  // private final AWSStorageService awsStorageService;

  private final FileProperties fileProperties;
  private final ModelMapper modelMapper;


  /**
   * Gets file.
   *
   * @param id the id
   * @return the file
   */
  @Cacheable("attachFile")
  public FileDto.Response getFile(final Long id) {
    return modelMapper
            .map(attachFileRepository.findById(id).orElseThrow(IllegalArgumentException::new),
                    FileDto.Response.class);
  }

  /**
   * Store file list.
   *
   * @param files the files
   * @return the list
   */
  @Transactional
  public List<FileDto.Response> storeFile(List<MultipartFile> files, boolean isSecret) {
    if (CollectionUtils.isEmpty(files)) {
      return Lists.newArrayList();
    }
    List<FileDto.Response> results = Lists.newArrayList();
    for (MultipartFile file : files) {
      results.add(storeFile(file, isSecret));
    }
    return results;
  }

  /**
   * Store file file dto . response.
   *
   * @param file the file
   * @return the file dto . response
   */
  @Transactional
  public FileDto.Response storeFile(MultipartFile file, boolean isSecret) {
    LocalDateTime now = LocalDateTime.now();
    AttachFile attachFile = AttachFile.builder()
            .filename(file.getOriginalFilename())
            .contentType(file.getContentType())
            .size(file.getSize())
            .serverPath(now.format(DateTimeFormatter.ofPattern("yyyy/MM")))
            .isSecret(isSecret)
            .build();

    AttachFile savedAttachFile = attachFileRepository.save(attachFile);
    Path filePath = Paths.get(savedAttachFile.getServerFilePath());
    // awsStorageService.store(file, filePath, isSecret);

    return modelMapper.map(savedAttachFile, FileDto.Response.class);

  }

  /**
   * Load file file dto . download.
   *
   * @param id the id
   * @return the file dto . download
   */
  public FileDto.Download loadFile(final Long id) {
    AttachFile attachFile = attachFileRepository.findById(id)
            .orElseThrow(IllegalArgumentException::new);

    Resource resource = storageService.loadAsResource(attachFile.getServerFilePath());
    return FileDto.Download.builder()
            .attachFile(modelMapper.map(attachFile, FileDto.Response.class))
            .resource(resource)
            .build();
  }

  /**
   * Load file file dto . download.
   *
   * @param id     the id
   * @param width  the width
   * @param height the height
   * @param type   the type
   * @return the file dto . download
   */
  public FileDto.Download loadFile(final Long id, Long width, Long height, final String type) {
    AttachFile attachFile = attachFileRepository.findById(id)
            .orElseThrow(IllegalArgumentException::new);

    String convertedFileName = width + "x" + height + "_" + type + ".jpg";
    Path originPath = Paths.get(attachFile.getServerFilePath());
    Path convertedPath = originPath.getParent().resolve(convertedFileName);

    Path absoluteOriginPath = storageService.load(originPath.toString());
    Path absoluteConvertedPath = absoluteOriginPath.getParent().resolve(convertedFileName);

    try {
      try {
        Resource resource = storageService.loadAsResource(convertedPath.toString());
        if (resource.exists() && resource.isFile()) {
          return FileDto.Download.builder()
                  .attachFile(modelMapper.map(attachFile, FileDto.Response.class))
                  .resource(resource)
                  .build();
        }
      } catch (Exception e) {
        // nothing
        log.error(e.getMessage());
      }

      if (!type.equals("crop")) {
        BufferedImage bufferedImage = ImageIO.read(originPath.toFile());
        float w = (float) bufferedImage.getWidth() / (float) width;
        float h = (float) bufferedImage.getHeight() / (float) height;
        if (h > w) {
          width = 0L;
        } else {
          height = 0L;
        }
      }

      Map<String, String> args = new LinkedHashMap<>();
      args.put("-resize", width + "x" + height + "^");
      args.put("-quality", "90");
      args.put("-gravity", "center");
      args.put("-auto-orient", "");
      args.put("-crop", width + "x" + height + "+0+0");
      args.put("+repage", "");

      String commandArgs = mapToCommand(args);
      List<String> commandList = Lists.newLinkedList();
      if (System.getProperty("os.name").contains("windows")) {
        commandList.add("\"" + fileProperties.getExtensionConvert() + "\"");
        commandList.add(
                absoluteOriginPath.toString() + ((attachFile.isGif() || attachFile.isVideo())
                        ? "[0]"
                        : ""));
        commandList.add(commandArgs);
        commandList.add(absoluteConvertedPath.toString());
      } else {
        commandList.add(fileProperties.getExtensionConvert());
        commandList.add(absoluteOriginPath.toString() + (
                (attachFile.isGif() || attachFile.isVideo()) ? "[0]" : ""));
        commandList.add(commandArgs);
        commandList.add(absoluteConvertedPath.toString());
      }

      String command = String.join(" ", commandList);
      log.info("command: {}", command);

      try {
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
      } catch (Exception e) {
        // nothing
        log.error("Error occurrence", e);
      }

      return FileDto.Download.builder()
              .attachFile(modelMapper.map(attachFile, FileDto.Response.class))
              .resource(storageService.loadAsResource(convertedPath.toString()))
              .build();
    } catch (IOException e) {
      throw new RuntimeException("Failed to load file " + convertedPath, e);
    }
  }

  private String mapToCommand(final Map<String, String> map) {
    return map.keySet().stream()
            .map(key -> key + " " + map.get(key))
            .collect(Collectors.joining(" "));
  }

  private Path createDirectory(Path path) {
    try {
      Files.createDirectories(path);
    } catch (FileAlreadyExistsException e) {
      log.error("File already exists: {}", e.getMessage());
    } catch (IOException e) {
      throw new RuntimeException("Failed to create directory", e);
    }
    return path;
  }

  public List<FileDto.Response> getFiles(List<Long> ids) {
    List<AttachFile> files = attachFileRepository.findAllById(ids);
    return files.stream().map(f -> modelMapper.map(f, FileDto.Response.class))
            .collect(Collectors.toList());
  }
}
