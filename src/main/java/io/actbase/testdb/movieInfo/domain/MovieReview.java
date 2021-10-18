// package io.actbase.testdb.movieInfo.domain;

// import lombok.Getter;
// import lombok.Setter;
// import lombok.NoArgsConstructor;
// import lombok.experimental.SuperBuilder;
// import lombok.AllArgsConstructor;
// import lombok.EqualsAndHashCode;
// import io.actbase.testdb.review.domain.Review;

// import javax.persistence.*;

// @Entity
// @Getter
// @Setter
// // @EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
// @NoArgsConstructor
// // @AllArgsConstructor
// @SuperBuilder
// public class MovieReview {

//    @ManyToOne(optional = false)
//    private MovieInfo movieInfo;

//    @ManyToOne(optional = true)
//    private Review review;

//    private int reviewId;

//    private String threadType;

//    private boolean withImage;

//    private String userName;

//    private int likeCount;

//    private int commentCount;

//    private String reviewDescription;

//    private String createdAt;

//    private String userProfile;

//    private String snsIcons;

//    private String reviewTitle;

//    private String hashTags;

//    private String userHashTags;
// }


