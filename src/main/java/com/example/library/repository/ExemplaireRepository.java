package com.example.library.repository;

import com.example.library.model.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {
    List<Exemplaire> findByLivreIsbnAndEtat(
        String isbn,
        Exemplaire.EtatExemplaire etat);
}
