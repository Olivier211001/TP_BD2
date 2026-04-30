package com.example.library.repository;

import com.example.library.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository 
        extends JpaRepository<Paiement, Long> {

    List<Paiement> findByMembreId(Long idMembre);
    List<Paiement> findByStatut(String statut);
}