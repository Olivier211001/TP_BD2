package com.example.library.service.impl;

import com.example.library.model.TransactionEmprunt;
import com.example.library.repository.TransactionEmpruntRepository;
import com.example.library.service.TransactionEmpruntService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionEmpruntServiceImpl implements TransactionEmpruntService {

    private final TransactionEmpruntRepository transactionRepository;

    public TransactionEmpruntServiceImpl(TransactionEmpruntRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionEmprunt> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<TransactionEmprunt> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public TransactionEmprunt save(TransactionEmprunt transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
