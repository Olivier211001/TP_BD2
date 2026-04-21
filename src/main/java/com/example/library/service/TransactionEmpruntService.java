package com.example.library.service;

import com.example.library.model.TransactionEmprunt;

import java.util.List;
import java.util.Optional;

public interface TransactionEmpruntService {
    List<TransactionEmprunt> findAll();

    Optional<TransactionEmprunt> findById(Long id);

    TransactionEmprunt save(TransactionEmprunt transaction);

    void deleteById(Long id);
}
