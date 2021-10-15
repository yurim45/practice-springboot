package io.actbase.testdb.review.controller;

import io.actbase.testdb.review.dto.ReviewDto;
import io.actbase.testdb.review.service.ReviewService;
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


@Api(tags = {"Review API"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @ApiOperation(value = "Review 조회")
    @GetMapping
    ResponseEntity getReview(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<ReviewDto.Response> page = reviewService.getReviews(pageable);
        return ResponseEntity.ok(page);
    }

    @ApiOperation(value = "Review 등록")
    @PostMapping
    ResponseEntity createReview(
            @RequestBody @Valid ReviewDto.Create dto
    ) {
        ReviewDto.Response savedPost = reviewService.createReview(dto);
        return ResponseEntity.ok(savedPost);
    }

    @ApiOperation(value = "Review 삭제")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteReview(
            @ApiParam(required = true, example = "1") @PathVariable final Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
