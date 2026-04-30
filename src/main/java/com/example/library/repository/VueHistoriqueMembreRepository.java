package com.example.library.repository;

import com.example.library.views.VueHistoriqueMembre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VueHistoriqueMembreRepository
        extends JpaRepository<VueHistoriqueMembre, Long> {

            List<VueHistoriqueMembre> findByIdMembre(Long idMembre);
            List<VueHistoriqueMembre> findByNomContainingIgnoreCase(String nom);
            List<VueHistoriqueMembre> findByEtatEmprunt(String etat);}