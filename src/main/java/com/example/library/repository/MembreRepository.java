package com.example.library.repository;

import com.example.library.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre, Long> {
}
