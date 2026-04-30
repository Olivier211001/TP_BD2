package com.example.library.repository;

import com.example.library.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivreRepository 
        extends JpaRepository<Livre, String> {

    List<Livre> findByTitreContainingIgnoreCase(String titre);
    List<Livre> findByCategorieId(Long idCat);
}