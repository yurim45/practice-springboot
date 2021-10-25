package io.actbase.testdb.movieInfo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

public class MovieInfoDto {
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @ApiModel(value = "MovieInfoDto.Response")
    public static class Response {

        @ApiModelProperty(value = "id", example = "1")
        private Long id;

        @ApiModelProperty(value = "movieInfoId", example = "1", required = false, position = 2)
        private int movieInfoId;

        @ApiModelProperty(value = "movieTitle", example = "승리호", required = false, position = 3)
        private String movieTitle;

        @ApiModelProperty(value = "category", example = "코미디", required = false, position = 4)
        private String category;

        @ApiModelProperty(value = "tomato", example = "90", required = false, position = 5)
        private int tomato;

        @ApiModelProperty(value = "releaseAt", example = "2021", required = false, position = 6)
        private String releaseAt;

        @ApiModelProperty(value = "availableOn", example = "", required = false, position = 7)
        private String availableOn;

        @ApiModelProperty(value = "score", example = "4.5", required = false, position = 8)
        private String score;

        @ApiModelProperty(value = "description", example = "우린 답을 찾을 거야, 늘 그랬듯이 세계 각국의 정부와 경제가 완전히 붕괴된 미래가 다가온다.", required = false, position = 9)
        private String description;
        
        @ApiModelProperty(value = "ratingRegulation", example = "12", required = false, position = 10)
        private int ratingRegulation;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @ApiModel(value = "MovieInfoDto.Create")
    public static class Create {

        @ApiModelProperty(value = "movieInfoId", example = "1", required = false, position = 1)
        private int movieInfoId;

        @ApiModelProperty(value = "movieTitle", example = "승리호", required = false, position = 2)
        private String movieTitle;

        @ApiModelProperty(value = "category", example = "코미디", required = false, position = 3)
        private String category;

        @ApiModelProperty(value = "tomato", example = "90", required = false, position = 4)
        private int tomato;

        @ApiModelProperty(value = "releaseAt", example = "2021", required = false, position = 5)
        private String releaseAt;

        @ApiModelProperty(value = "availableOn", example = "", required = false, position = 6)
        private String availableOn;

        @ApiModelProperty(value = "score", example = "4.5", required = false, position = 7)
        private String score;

        @ApiModelProperty(value = "description", example = "우린 답을 찾을 거야, 늘 그랬듯이 세계 각국의 정부와 경제가 완전히 붕괴된 미래가 다가온다.", required = false, position = 8)
        private String description;
        
        @ApiModelProperty(value = "ratingRegulation", example = "12", required = false, position = 9)
        private int ratingRegulation;

    }

}

