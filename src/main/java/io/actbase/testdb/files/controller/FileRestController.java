// package io.actbase.testdb.files.controller;

// import io.actbase.testdb.common.infra.web.storage.service.StorageService;
// import io.actbase.testdb.files.dto.FileDto;
// import io.actbase.testdb.files.dto.FileDto.Response;
// import io.actbase.testdb.files.service.FileService;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiParam;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;

// import java.util.List;

// @Api(tags = {"파일첨부 API"})
// @Slf4j
// @RequiredArgsConstructor
// @RestController
// @RequestMapping(path = "/api/files")
// public class FileRestController {

//     private final FileService fileService;


//     @Value("${app.aws.cdn-thumb-url}")
//     private String cdnThumbUrl;

//     @Value("${app.aws.cdn-origin-url}")
//     private String cdnOriginUrl;


//     @Value("${app.aws.end-point}")
//     private String localFileFolder;

//     @ApiOperation(value = "파일 업로드", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//     @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//     public FileDto.Response uploadFile(
//             @ApiParam(value = "Select the file to Upload", required = true) MultipartFile file,
//             @ApiParam(value = "true", defaultValue = "true", required = true) boolean isSecret
//     ) {
//         return fileService.storeFile(file, isSecret);
//     }

//     @ApiOperation(value = "다중 파일 업로드", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//     @PostMapping(path = "/multiple", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//     public List<FileDto.Response> uploadFile(
//             @ApiParam(value = "Select the files to Upload", required = true) List<MultipartFile> files,
//             @ApiParam(value = "1", required = true) boolean isSecret
//     ) {
//         return fileService.storeFile(files, isSecret);
//     }

//     @GetMapping("/info")
//     public ResponseEntity<List<FileDto.Response>> infoFiles(
//             @RequestParam("ids") List<Long> ids
//     ) {
//         return ResponseEntity.ok(fileService.getFiles(ids));
//     }

//     @ApiOperation(value = "파일 다운로드")
//     @GetMapping("/{id}")
//     public ResponseEntity downloadFile(
//             @PathVariable("id") Long id,
//             @RequestParam(required = false) boolean isAttachFile
//     ) {
//         Response file = fileService.getFile(id);
//         if (!file.isSecret()) {
//             String location = cdnOriginUrl + "/" + file.getServerFilePath();

//             HttpHeaders headers = new HttpHeaders();
//             headers.add("Location", location);
//             return new ResponseEntity<String>(headers, HttpStatus.FOUND);
//         } else {
//             return ResponseEntity.ok(404);
//         }
//     }

//     @ApiOperation(value = "썸네일 다운로드")
//     @GetMapping("/{id}/thumb")
//     public ResponseEntity downloadThumbnail(
//             @PathVariable("id") Long id,
//             @ApiParam(example = "200") @RequestParam(value = "w", required = false) Long width,
//             @ApiParam(example = "200") @RequestParam(value = "h", required = false) Long height,
//             @ApiParam(example = "crop") @RequestParam(value = "t", required = false, defaultValue = "crop") String type
//     ) {
//         Response file = fileService.getFile(id);
//         String location = "";

//         if (width > 0 && (height == null || height <= 0)) {
//             location = cdnThumbUrl + "/" + file.getServerFilePath() + "?type=w&w=" + width;
//         } else {
//             location =
//                     cdnThumbUrl + "/" + file.getServerFilePath() + "?type=f&w=" + width + "&h=" + height;
//         }

//         HttpHeaders headers = new HttpHeaders();
//         headers.add("Location", location);
//         return new ResponseEntity<String>(headers, HttpStatus.FOUND);
//     }

// }
