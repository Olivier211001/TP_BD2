package com.example.library.repository;

import com.example.library.views.VueHistoriqueMembre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueHistoriqueMembreRepository
        extends JpaRepository<VueHistoriqueMembre, Long> {

}