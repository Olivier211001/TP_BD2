package com.example.library.repository;

import com.example.library.views.VueEmployes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueEmployesRepository
        extends JpaRepository<VueEmployes, Long> {

}