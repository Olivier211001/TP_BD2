package com.example.library.repository;

import com.example.library.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MembreRepository 
        extends JpaRepository<Membre, Long> {

    Optional<Membre> findByNomAndPassword(String nom, String password);
    List<Membre> findByStatutCompte(Membre.StatutCompte statut);
    List<Membre> findByNomContainingIgnoreCase(String nom);
}