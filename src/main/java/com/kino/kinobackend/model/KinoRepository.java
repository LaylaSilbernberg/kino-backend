package com.kino.kinobackend.model;

import com.kino.kinobackend.model.repository.dao.MovieDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KinoRepository extends JpaRepository<MovieDAO, UUID> {
}
