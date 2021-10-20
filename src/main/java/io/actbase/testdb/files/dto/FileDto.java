//package io.actbase.testdb.files.dto;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import java.time.LocalDateTime;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.core.io.Resource;
//import org.springframework.http.MediaType;
//
///**
// * The type File dto.
// *
// * @author eomjeongjae
// * @since 2019 /10/15
// */
//public class FileDto {
//
//  /**
//   * The type Download.
//   */
//  @Getter
//  @Setter
//  @NoArgsConstructor
//  @AllArgsConstructor
//  @ToString
//  @Builder
//  public static class Download {
//
//    private Response attachFile;
//
//    private Resource resource;
//
//  }
//
//  /**
//   * The type Response.
//   */
//  @Getter
//  @Setter
//  @NoArgsConstructor
//  @AllArgsConstructor
//  @ToString
//  @Builder
//  @ApiModel("FileDto.Response")
//  public static class Response {
//
//    private Long id;
//
//    private String serverPath;
//
//    private String filename;
//
//    private String extension;
//
//    private String contentType;
//
//    private Long size;
//
//    @ApiModelProperty(hidden = true)
//    private MediaType mediaType;
//
//    private boolean isImage;
//
//    private String serverFilePath;
//
//    private LocalDateTime createdAt;
//
//    @ApiModelProperty(value = "비밀 여부", example = "true", required = true)
//    private boolean isSecret;
//
//    private String link;
//
//  }
//}
