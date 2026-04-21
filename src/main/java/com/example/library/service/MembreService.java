package com.example.library.service;

import com.example.library.model.Membre;

import java.util.List;
import java.util.Optional;

public interface MembreService {
    List<Membre> findAll();

    Optional<Membre> findById(Long id);

    Membre save(Membre membre);

    void deleteById(Long id);
}
