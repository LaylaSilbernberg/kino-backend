package com.kino.kinobackend.model.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kino.kinobackend.model.repository.dao.MovieDAO;
import com.kino.kinobackend.model.repository.dao.RatingsDAO;

public record Rating(@JsonProperty("Source") String source,
                     @JsonProperty("Value") String value) {

    public RatingsDAO toDAO(MovieDAO movie){
        return new RatingsDAO(
                this.source,
                this.value,
                movie
        );
    }
}
