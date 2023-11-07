package com.kino.kinobackend.model.repository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}
