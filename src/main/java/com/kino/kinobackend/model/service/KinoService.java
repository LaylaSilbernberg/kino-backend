package com.kino.kinobackend.model.service;

import com.kino.kinobackend.model.KinoRepository;
import com.kino.kinobackend.model.repository.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@Service
public class KinoService {

    private final WebClient webClient;

    private KinoRepository repo;

    public KinoService(@Autowired WebClient webClient, @Autowired KinoRepository repo) {
        this.webClient = webClient;
        this.repo = repo;
    }

    public MovieDTO getMovieByTitle(String title) {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.queryParam("t", title).build())
                .exchangeToMono(response -> response.bodyToMono(MovieDTO.class))
                .block();
    }
}
