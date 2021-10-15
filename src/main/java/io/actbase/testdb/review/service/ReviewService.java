package io.actbase.testdb.review.service;

import io.actbase.testdb.review.domain.Review;
import io.actbase.testdb.review.domain.ReviewRepository;
import io.actbase.testdb.review.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public ReviewDto.Response createReview(ReviewDto.Create dto) {
        Review newReport = modelMapper.map(dto, Review.class);
        return toResponse(reviewRepository.save(newReport));
    }

    public Page<ReviewDto.Response> getReviews(Pageable pageable) {
        Page<Review> page = reviewRepository.findAll(pageable);
        List<ReviewDto.Response> content = page.getContent().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(content, pageable, page.getTotalElements());
    }

    @Transactional
    public void deleteReview(
            final Long id
    ) {
        Review existReport = this.validate(id);
        reviewRepository.delete(existReport);
    }

    private ReviewDto.Response toResponse(Review review) {
        return modelMapper.map(review, ReviewDto.Response.class);
    }

    private Review validate(
            final Long id
    ) {

        Review existReview = reviewRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return existReview;
    }
}
