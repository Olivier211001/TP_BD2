package com.example.library.service;

import com.example.library.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> findAll();

    Optional<Transaction> findById(Long id);

    Transaction save(Transaction transaction);

    void deleteById(Long id);
}
