package com.kino.kinobackend.model.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kino.kinobackend.model.repository.dao.MovieDAO;
import com.kino.kinobackend.model.repository.dao.RatingsDAO;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieDTO(@JsonProperty("Title") String title,
                    @JsonProperty("Year") String year,
                    @JsonProperty("Rated") String rated,
                    @JsonProperty("Released") String released,
                    @JsonProperty("Runtime") String runtime,
                    @JsonProperty("Genre") String genre,
                    @JsonProperty("Director") String director,
                    @JsonProperty("Writer") String writer,
                    @JsonProperty("Actors") String actors,
                    @JsonProperty("Plot") String plot,
                    @JsonProperty("Language") String languages,
                    @JsonProperty("Country") String country,
                    @JsonProperty("Awards") String awards,
                    @JsonProperty("Poster") String posterURL,
                    @JsonProperty("Ratings") Rating[] ratings,
                    @JsonProperty("DVD") String dvdRelease,
                    @JsonProperty("BoxOffice") String boxOffice) {

    public MovieDAO toDAO(){
        MovieDAO dao = new MovieDAO(this.title,
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
                this.dvdRelease,
                this.boxOffice);

        List<RatingsDAO> ratings = Arrays
                .stream(this.ratings)
                .map(rating -> rating.toDAO(dao))
                .toList();
        dao.setRatings(ratings);

        return dao;
    }
}
