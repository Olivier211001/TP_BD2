package com.example.library.service;

import com.example.library.model.Livre;

import java.util.List;
import java.util.Optional;

public interface LivreService {
    List<Livre> findAll();
    Optional<Livre> findByIsbn(String isbn);
    Livre save(Livre livre);
    void deleteByIsbn(String isbn);
}
