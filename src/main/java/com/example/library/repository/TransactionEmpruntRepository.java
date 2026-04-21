package com.example.library.repository;

import com.example.library.model.TransactionEmprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEmpruntRepository extends JpaRepository<TransactionEmprunt, Long> {
}
