package io.actbase.testdb.movieInfo.dto;


import lombok.Setter;
import lombok.Getter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.actbase.testdb.movieInfo.dto.MovieInfoDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

public class MovieReviewDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @SuperBuilder
    @ToString
    @ApiModel(value = "MovieReviewDto.Response")
    public static class Response {

        @ApiModelProperty(value = "영화정보", position = 1, required = true)
        private MovieInfoDto.Response movieInfo;

        
    }
}