package com.example.library.repository;

import com.example.library.views.VueEmpruntsEnCours;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VueEmpruntsEnCoursRepository
        extends JpaRepository<VueEmpruntsEnCours, Long> {
                List<VueEmpruntsEnCours> findByMembreNomContainingIgnoreCase(String nom);
                List<VueEmpruntsEnCours> findByEtat(String etat);
}