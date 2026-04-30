package com.example.library.repository;

import com.example.library.views.VueLogAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VueLogAdminRepository
        extends JpaRepository<VueLogAdmin, Long> {
                List<VueLogAdmin> findByTypeOperation(String typeOperation);
                List<VueLogAdmin> findByTableVisee(String tableVisee);
                List<VueLogAdmin> findByEmployeNomContainingIgnoreCase(String nom);
}