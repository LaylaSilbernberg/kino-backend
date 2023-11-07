package com.kino.kinobackend.controller;

import com.kino.kinobackend.model.repository.dto.MovieDTO;
import com.kino.kinobackend.model.service.KinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kino")
public class KinoController {

    private KinoService service;

    public KinoController(@Autowired KinoService service) {
        this.service = service;
    }

    @GetMapping("{title}")
    public ResponseEntity<MovieDTO> getMovieByTitle(@PathVariable String title){
        return ResponseEntity.ok(service.getMovieByTitle(title));
    }
}
