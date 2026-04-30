package com.example.library.repository;

import com.example.library.views.VueRetards;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VueRetardsRepository
        extends JpaRepository<VueRetards, Long> {
                List<VueRetards> findByNomContainingIgnoreCase(String nom);
                List<VueRetards> findByJoursRetardGreaterThan(Integer jours);
}