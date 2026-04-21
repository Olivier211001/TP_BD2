package com.example.library.repository;

import com.example.library.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, String> {
}
