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

        @ApiModelProperty(value = "type", example = "type", required = false, position = 1)
        private String type;

        @ApiModelProperty(value = "reviewId", example = "1", required = false, position = 2)
        private int reviewId;

        @ApiModelProperty(value = "userName", example = "userName", required = false, position = 3)
        private String userName;

        @ApiModelProperty(value = "profilePic", example = "profilePic", required = false, position = 4)
        private String profilePic;

        @ApiModelProperty(value = "time", example = "YYYY-MM-DD", required = false, position = 5)
        private String time;

        @ApiModelProperty(value = "reviewImage", example = "reviewImage", required = false, position = 6)
        private String reviewImage;

        @ApiModelProperty(value = "score", example = "score", required = false, position = 7)
        private String score;

        @ApiModelProperty(value = "title", example = "title", required = false, position = 8)
        private String title;

        @ApiModelProperty(value = "commentCount", example = "1", required = false, position = 9)
        private int commentCount;

        @ApiModelProperty(value = "likeCount", example = "1", required = false, position = 10)
        private int likeCount;


    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @ApiModel(value = "ReviewDto.Create")
    public static class Create {

        @ApiModelProperty(value = "type", example = "type", required = false, position = 1)
        private String type;

        @ApiModelProperty(value = "reviewId", example = "1", required = false, position = 2)
        private int reviewId;

        @ApiModelProperty(value = "userName", example = "userName", required = false, position = 3)
        private String userName;

        @ApiModelProperty(value = "profilePic", example = "profilePic", required = false, position = 4)
        private String profilePic;

        @ApiModelProperty(value = "time", example = "YYYY-MM-DD", required = false, position = 5)
        private String time;

        @ApiModelProperty(value = "reviewImage", example = "reviewImage", required = false, position = 6)
        private String reviewImage;

        @ApiModelProperty(value = "score", example = "score", required = false, position = 7)
        private String score;

        @ApiModelProperty(value = "title", example = "title", required = false, position = 8)
        private String title;

        @ApiModelProperty(value = "commentCount", example = "1", required = false, position = 9)
        private int commentCount;

        @ApiModelProperty(value = "likeCount", example = "1", required = false, position = 10)
        private int likeCount;
    }

    }

