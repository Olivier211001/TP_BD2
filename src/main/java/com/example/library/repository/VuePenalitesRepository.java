package com.example.library.repository;

import com.example.library.views.VuePenalites;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VuePenalitesRepository
        extends JpaRepository<VuePenalites, Long> {
                List<VuePenalites> findByStatut(String statut);
                List<VuePenalites> findByNomContainingIgnoreCase(String nom);
}