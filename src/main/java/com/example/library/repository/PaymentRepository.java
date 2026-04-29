package com.example.library.repository;

import com.example.library.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Paiement, Long> {
}
