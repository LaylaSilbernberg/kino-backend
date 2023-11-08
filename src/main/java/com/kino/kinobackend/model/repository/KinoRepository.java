package com.kino.kinobackend.model.repository;

import com.kino.kinobackend.model.repository.dao.MovieDAO;
import com.kino.kinobackend.model.repository.dto.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface KinoRepository extends JpaRepository<MovieDAO, UUID> {
    Optional<MovieDAO> findByTitle(String title);

}
