package io.actbase.testdb.movieInfo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MovieInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "movieInfoId")
    private int movieInfoId;

    @Column(name = "movieTitle")
    private String movieTitle;

    @Column(name = "category")
    private String category;

    @Column(name = "tomato")
    private int tomato;

    @Column(name = "releaseAt")
    private String releaseAt;

    @Column(name = "availableOn")
    private String availableOn;

    @Column(name = "score")
    private String score;

    @Column(name = "description")
    private String description;

    @Column(name = "ratingRegulation")
    private int ratingRegulation;


}


