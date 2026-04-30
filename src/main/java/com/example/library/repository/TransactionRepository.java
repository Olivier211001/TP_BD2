package com.example.library.repository;

import com.example.library.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findByMembreId(Long idMembre);
    List<Transaction> findByEtat(Transaction.EtatTransaction etat);
    List<Transaction> findByExemplaireId(Long idExemplaire);
}