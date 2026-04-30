package com.example.library.repository;

import com.example.library.views.VueEmployes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VueEmployesRepository
        extends JpaRepository<VueEmployes, Long> {
                List<VueEmployes> findByType(String type);
                List<VueEmployes> findByNomContainingIgnoreCase(String nom);
}