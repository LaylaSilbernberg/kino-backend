package com.kino.kinobackend.model.repository.dao;

import com.kino.kinobackend.model.repository.dto.MovieDTO;
import com.kino.kinobackend.model.repository.dto.Rating;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "movie")
public class MovieDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String year;

    private String rated;

    private String released;

    private String runtime;

    private String genre;

    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String languages;
    private String country;
    private String awards;
    private String posterURL;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<RatingsDAO> ratings;
    private String dvdRelease;
    private String boxOffice;

    protected MovieDAO(String title, String year, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String languages, String country, String awards, String posterURL, List<RatingsDAO> ratings, String dvdRelease, String boxOffice) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.languages = languages;
        this.country = country;
        this.awards = awards;
        this.posterURL = posterURL;
        this.ratings = ratings;
        this.dvdRelease = dvdRelease;
        this.boxOffice = boxOffice;
    }

    protected MovieDAO() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDAO movieDAO = (MovieDAO) o;
        return Objects.equals(id, movieDAO.id) && Objects.equals(title, movieDAO.title) && Objects.equals(year, movieDAO.year) && Objects.equals(rated, movieDAO.rated) && Objects.equals(released, movieDAO.released) && Objects.equals(runtime, movieDAO.runtime) && Objects.equals(genre, movieDAO.genre) && Objects.equals(director, movieDAO.director) && Objects.equals(writer, movieDAO.writer) && Objects.equals(actors, movieDAO.actors) && Objects.equals(plot, movieDAO.plot) && Objects.equals(languages, movieDAO.languages) && Objects.equals(country, movieDAO.country) && Objects.equals(awards, movieDAO.awards) && Objects.equals(posterURL, movieDAO.posterURL) && Objects.equals(ratings, movieDAO.ratings) && Objects.equals(dvdRelease, movieDAO.dvdRelease) && Objects.equals(boxOffice, movieDAO.boxOffice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, rated, released, runtime, genre, director, writer, actors, plot, languages, country, awards, posterURL, ratings, dvdRelease, boxOffice);
    }

    @Override
    public String toString() {
        return """
                MovieDAO{%s by %s, written by %s}"""
                .formatted(this.title, this.director, this.writer);
    }

    public MovieDTO toDTO(){
        return new MovieDTO(this.title,
                this.year,
                this.rated,
                this.released,
                this.runtime,
                this.genre,
                this.director,
                this.writer,
                this.actors,
                this.plot,
                this.languages,
                this.country,
                this.awards,
                this.posterURL,
                this.ratings
                        .stream()
                        .map(RatingsDAO::toDTO)
                        .toArray(Rating[]::new),
                this.dvdRelease,
                this.boxOffice
                );


    }
}
