package com.kino.kinobackend.model.service;

import com.kino.kinobackend.model.repository.KinoRepository;
import com.kino.kinobackend.model.repository.dao.MovieDAO;
import com.kino.kinobackend.model.repository.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class KinoService {

    private final WebClient webClient;

    private KinoRepository repo;

    public KinoService(@Autowired WebClient webClient, @Autowired KinoRepository repo) {
        this.webClient = webClient;
        this.repo = repo;
    }

    public MovieDTO getMovieByTitle(String title) {
        Optional<MovieDAO> dao = repo
                .findByTitle(title);

        if(dao.isPresent()){
            return dao.get().toDTO();
        }

        return insertMovie(webClient
                .get()
                .uri(uriBuilder -> uriBuilder.queryParam("t", title).build())
                .exchangeToMono(response -> response.bodyToMono(MovieDTO.class))
                .block());
    }

    public MovieDTO insertMovie(MovieDTO movie){
        return repo.save(movie.toDAO()).toDTO();
    }
}
