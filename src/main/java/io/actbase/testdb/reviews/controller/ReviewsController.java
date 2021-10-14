package io.actbase.testdb.reviews.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")

public class ReviewsController {
    @ApiOperation(value = "리뷰 목록 조회")
    @GetMapping("reviews")
    public String getReviews() {
        System.out.println("ReviewsController welcome");

        return "ReviewsController Welcome";
    }

    @ApiOperation(value = "리뷰 조회")
    @GetMapping("reviews/{id}")
    public String getReview(
            @ApiParam(value = "id", example = "1") @RequestParam("id") String phone
    ) {
        System.out.println("ReviewsController welcome");

        return "ReviewsController Welcome";
    }

}
