package com.example.library.repository;

import com.example.library.views.VueReservationsActives;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VueReservationsActivesRepository
        extends JpaRepository<VueReservationsActives, Long> {
                List<VueReservationsActives> findByNomContainingIgnoreCase(String nom);
                List<VueReservationsActives> findByEtat(String etat);
                Optional<VueReservationsActives> findByIdResAndEtat(Long idRes, String etat);
}