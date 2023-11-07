package com.kino.kinobackend.model.repository.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public final class MovieDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

}
