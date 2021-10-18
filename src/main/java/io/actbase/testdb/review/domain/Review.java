package io.actbase.testdb.review.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "reviewId")
    private int reviewId;

    @Column(name = "type")
    private String type;

    @Column(name = "threadType")
    private String threadType;

    @Column(name = "withImage")
    private boolean withImage;

    @Column(name = "userProfile")
    private String userProfile;

    @Column(name = "snsIcons")
    private String snsIcons;

    @Column(name = "hashTags")
    private String hashTags;

    @Column(name = "userHashTags")
    private String userHashTags;

    @Column(name = "userName")
    private String userName;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "reviewDescription")
    private String reviewDescription;

    @Column(name = "reviewImage")
    private String reviewImage;

    @Column(name = "score")
    private String score;

    @Column(name = "reviewTitle")
    private String reviewTitle;

    @Column(name = "commentCount")
    private int commentCount;

    @Column(name = "likeCount")
    private int likeCount;

    @Column(name = "runningTime")
    private int runningTime;


}


