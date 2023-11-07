package com.kino.kinobackend.model.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Rating(@JsonProperty("Source") String source,
                     @JsonProperty("Value") String value) {
}
