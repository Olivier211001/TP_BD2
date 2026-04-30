package com.example.library.repository;

import com.example.library.views.VueCatalogue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VueCatalogueRepository
        extends JpaRepository<VueCatalogue, String> {
                List<VueCatalogue> findByTitreContainingIgnoreCase(String titre);
                List<VueCatalogue> findByCategorie(String categorie);
                List<VueCatalogue> findByNbDisponiblesGreaterThan(Integer nb);
}