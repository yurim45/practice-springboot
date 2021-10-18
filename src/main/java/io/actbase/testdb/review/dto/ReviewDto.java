package io.actbase.testdb.review.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

public class ReviewDto {
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @ApiModel(value = "ReviewDto.Response")
    public static class Response {

        @ApiModelProperty(value = "id", example = "1")
        private Long id;

        @ApiModelProperty(value = "reviewId", example = "1", required = false, position = 2)
        private int reviewId;

        @ApiModelProperty(value = "type", example = "best", required = false, position = 3)
        private String type;

        @ApiModelProperty(value = "threadType", example = "MY_THREAD", required = false, position = 4)
        private String threadType;

        @ApiModelProperty(value = "withImage", example = "true", required = false, position = 5)
        private boolean withImage;

        @ApiModelProperty(value = "userProfile", example = "", required = false, position = 6)
        private String userProfile;

        @ApiModelProperty(value = "snsIcons", example = "", required = false, position = 7)
        private String snsIcons;

        @ApiModelProperty(value = "hashTags", example = "", required = false, position = 8)
        private String hashTags;

        @ApiModelProperty(value = "userHashTags", example = "", required = false, position = 9)
        private String userHashTags;

        @ApiModelProperty(value = "userName", example = "userName", required = false, position = 10)
        private String userName;

        @ApiModelProperty(value = "createdAt", example = "", required = false, position = 11)
        private String createdAt;

        @ApiModelProperty(value = "reviewDescription", example = "reviewDescription", required = false, position = 12)
        private String reviewDescription;

        @ApiModelProperty(value = "reviewImage", example = "reviewImage", required = false, position = 13)
        private String reviewImage;

        @ApiModelProperty(value = "score", example = "score", required = false, position = 14)
        private String score;

        @ApiModelProperty(value = "reviewTitle", example = "reviewTitle", required = false, position = 15)
        private String reviewTitle;

        @ApiModelProperty(value = "commentCount", example = "1", required = false, position = 16)
        private int commentCount;

        @ApiModelProperty(value = "likeCount", example = "1", required = false, position = 17)
        private int likeCount;

        @ApiModelProperty(value = "runningTime", example = "100", required = false, position = 18)
        private int runningTime;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @ApiModel(value = "ReviewDto.Create")
    public static class Create {

        @ApiModelProperty(value = "reviewId", example = "1", required = false, position = 1)
        private int reviewId;

        @ApiModelProperty(value = "type", example = "best", required = false, position = 2)
        private String type;

        @ApiModelProperty(value = "threadType", example = "MY_THREAD", required = false, position = 3)
        private String threadType;

        @ApiModelProperty(value = "withImage", example = "true", required = false, position = 4)
        private boolean withImage;

        @ApiModelProperty(value = "userProfile", example = "", required = false, position = 5)
        private String userProfile;

        @ApiModelProperty(value = "snsIcons", example = "", required = false, position = 6)
        private String snsIcons;

        @ApiModelProperty(value = "hashTags", example = "", required = false, position = 7)
        private String hashTags;

        @ApiModelProperty(value = "userHashTags", example ="", required = false, position = 8)
        private String userHashTags;

        @ApiModelProperty(value = "userName", example = "userName", required = false, position = 9)
        private String userName;

        @ApiModelProperty(value = "createdAt", example = "", required = false, position = 10)
        private String createdAt;

        @ApiModelProperty(value = "reviewDescription", example = "reviewDescription", required = false, position = 11)
        private String reviewDescription;

        @ApiModelProperty(value = "reviewImage", example = "reviewImage", required = false, position = 12)
        private String reviewImage;

        @ApiModelProperty(value = "score", example = "score", required = false, position = 13)
        private String score;

        @ApiModelProperty(value = "reviewTitle", example = "reviewTitle", required = false, position = 14)
        private String reviewTitle;

        @ApiModelProperty(value = "commentCount", example = "1", required = false, position = 15)
        private int commentCount;

        @ApiModelProperty(value = "likeCount", example = "1", required = false, position = 16)
        private int likeCount;

        @ApiModelProperty(value = "runningTime", example = "100", required = false, position = 17)
        private int runningTime;

    }

}

