package com.kino.kinobackend.model.repository.dao;

import com.kino.kinobackend.model.repository.dto.Rating;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public final class RatingsDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String source;
    @Column(name = "value_of_rating")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private MovieDAO movie;

    public MovieDAO getMovie() {
        return movie;
    }

    public RatingsDAO(String source, String value, MovieDAO movie) {
        this.source = source;
        this.value = value;
        this.movie = movie;
    }

    public RatingsDAO() {
    }

    public Rating toDTO(){
        return new Rating(this.source,
                this.value);
    }
}
