package io.actbase.testdb.reviews.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "REVIEWS")

public class Reviews {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "reviewId")
    private String reviewId;

    @Column(name = "profilePic")
    private String profilePic;

    @Column(name = "userName")
    private String userName;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "reviewImage")
    private String reviewImage;

    @Column(name = "score")
    private String score;

    @Column(name = "title")
    private String title;

    @Column(name = "commentCount")
    private String commentCount;

    @Column(name = "likeCount")
    private String likeCount;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getReviewId() {
//        return reviewId;
//    }
//
//    public void setReviewId(String reviewId) {
//        this.reviewId = reviewId;
//    }
//
//    public String getProfilePic() {
//        return profilePic;
//    }
//
//    public void setProfilePic(String profilePic) {
//        this.profilePic = profilePic;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public String getReviewImage() {
//        return reviewImage;
//    }
//
//    public void setReviewImage(String reviewImage) {
//        this.reviewImage = reviewImage;
//    }
//
//    public String getScore() {
//        return score;
//    }
//
//    public void setScore(String score) {
//        this.score = score;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getCommentCount() {
//        return commentCount;
//    }
//
//    public void setCommentCount(String commentCount) {
//        this.commentCount = commentCount;
//    }
//
//    public String getLikeCount() {
//        return likeCount;
//    }
//
//    public void setLikeCount(String likeCount) {
//        this.likeCount = likeCount;
//    }

}
