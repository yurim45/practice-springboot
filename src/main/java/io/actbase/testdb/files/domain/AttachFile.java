//package io.actbase.testdb.files.domain;
//
//import io.actbase.testdb.common.infra.jpa.domain.BaseEntity;
//import lombok.*;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.http.MediaType;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//
///**
// * The type Attach file.
// *
// * @author eomjeongjae
// * @since 2019 /10/15
// */
//@Slf4j
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
////@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
//@Entity
//public class AttachFile extends BaseEntity {
//
//    @Column(nullable = false)
//    private String serverPath;
//
//    @Column(nullable = false)
//    private String filename;
//
//    @Column(length = 20)
//    private String extension;
//
//    @Column(length = 30, nullable = false)
//    private String contentType;
//
//    @Column(nullable = true, columnDefinition = "tinyint(1) default 0", length = 1)
//    private boolean isSecret;
//
//    @Builder.Default
//    private Long size = 0L;
//
//    /**
//     * Sets filename.
//     *
//     * @param filename the filename
//     */
//    public void setFilename(String filename) {
//        this.filename = filename;
//        this.extension = AttachFile.extractExtension(filename);
//    }
//
//    /**
//     * The type Attach file builder.
//     */
//    public static class AttachFileBuilder {
//
//        /**
//         * Filename attach file builder.
//         *
//         * @param filename the filename
//         * @return the attach file builder
//         */
//        public AttachFileBuilder filename(String filename) {
//            this.filename = filename;
//            this.extension = AttachFile.extractExtension(filename);
//            return this;
//        }
//    }
//
//    /**
//     * Is image boolean.
//     *
//     * @return the boolean
//     */
//    public boolean isImage() {
//        return getMediaType().isCompatibleWith(MediaType.IMAGE_JPEG);
//    }
//
//    /**
//     * Is gif boolean.
//     *
//     * @return the boolean
//     */
//    public boolean isGif() {
//        return getMediaType().equals(MediaType.IMAGE_GIF);
//    }
//
//    /**
//     * Is video boolean.
//     *
//     * @return the boolean
//     */
//    public boolean isVideo() {
//        return getMediaType().getType().startsWith("video");
//    }
//
//    /**
//     * Gets media type.
//     *
//     * @return the media type
//     */
//    public MediaType getMediaType() {
//        MediaType mediaType = null;
//        try {
//            mediaType = MediaType.parseMediaType(this.contentType);
//        } catch (Exception e) {
//            log.error("Fail parse media type");
//        }
//
//        if (mediaType == null) {
//            mediaType = MediaType.APPLICATION_OCTET_STREAM;
//        }
//        return mediaType;
//    }
//
//    /**
//     * Gets server file path.
//     *
//     * @return the server file path
//     */
//    public String getServerFilePath() {
//        return this.serverPath
//                + "/"
//                + this.getId()
//                + "/"
//                + this.getServerFilename();
//    }
//
//    /**
//     * Gets server filename.
//     *
//     * @return the server filename
//     */
//    public String getServerFilename() {
//        String serverFileName = "source";
//        if (StringUtils.isNotEmpty(this.extension)) {
//            serverFileName += "." + this.extension;
//        }
//        return serverFileName;
//    }
//
//    private static String extractExtension(String filename) {
//        if (filename.contains(".")) {
//            return filename.substring(filename.lastIndexOf(".") + 1);
//        }
//        return StringUtils.EMPTY;
//    }
//
//}
//
//
