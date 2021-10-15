package io.actbase.testdb.review.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "reviewId")
    private int reviewId;

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
    private int commentCount;

    @Column(name = "likeCount")
    private int likeCount;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(unique = true, nullable = false)
//    private Long id;
//
//    @Column(name = "type")
//    private String type;
//
//    @Column(name = "reviewId")
//    private String reviewId;
//
//    @Column(name = "profilePic")
//    private String profilePic;
//
//    @Column(name = "userName")
//    private String userName;
//
//    @Column(name = "time")
//    private LocalDateTime time;
//
//    @Column(name = "reviewImage")
//    private String reviewImage;
//
//    @Column(name = "score")
//    private String score;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "commentCount")
//    private String commentCount;
//
//    @Column(name = "likeCount")
//    private String likeCount;
}
