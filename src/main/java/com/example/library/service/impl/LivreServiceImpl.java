package com.example.library.service.impl;



import com.example.library.model.*;
import com.example.library.repository.LivreRepository;
import com.example.library.service.LivreService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LivreServiceImpl implements LivreService {

    private final LivreRepository repository;

    @PersistenceContext
    private EntityManager em;  // ← pour getReference()

    public LivreServiceImpl(LivreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Livre> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Livre> findByIsbn(String isbn) {
        return repository.findById(isbn);
    }

    @Override
    @Transactional
    public Livre save(Livre livre) {
        // Résoudre les références managées si ID fourni
        if (livre.getEditeur() != null && livre.getEditeur().getId() != null) {
            // getReference() retourne un proxy managed sans SELECT complet
            Editeur editeurRef = em.getReference(Editeur.class, livre.getEditeur().getId());
            livre.setEditeur(editeurRef);
        }
        if (livre.getCategorie() != null && livre.getCategorie().getId() != null) {
            Categorie categorieRef = em.getReference(Categorie.class, livre.getCategorie().getId());
            livre.setCategorie(categorieRef);
        }
        return repository.save(livre);
    }

    @Override
    @Transactional
    public void deleteByIsbn(String isbn) {
        repository.deleteById(isbn);
    }
}
