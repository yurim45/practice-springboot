package io.actbase.testdb.movieInfo.controller;

import io.actbase.testdb.movieInfo.dto.MovieInfoDto;
import io.actbase.testdb.movieInfo.service.MovieInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(tags = {"MovieInfo API"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movieInfo")
public class MovieInfoController {

    private final MovieInfoService movieInfoService;

    @ApiOperation(value = "영화정보 조회")
    @GetMapping
    ResponseEntity getMovieInfo(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<MovieInfoDto.Response> page = movieInfoService.getMovieInfo(pageable);
        return ResponseEntity.ok(page);
    }

    @ApiOperation(value = "영화정보 등록")
    @PostMapping
    ResponseEntity createMovieInfo(
            @RequestBody @Valid MovieInfoDto.Create dto
    ) {
        MovieInfoDto.Response savedPost = movieInfoService.createMovieInfo(dto);
        return ResponseEntity.ok(savedPost);
    }

    @ApiOperation(value = "영화정보 삭제")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteMovieInfo(
            @ApiParam(required = true, example = "1") @PathVariable final Long id) {
        movieInfoService.deleteMovieInfo(id);
        return ResponseEntity.noContent().build();
    }
}
