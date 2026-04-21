package com.example.library.service.impl;

import com.example.library.model.Livre;
import com.example.library.repository.LivreRepository;
import com.example.library.service.LivreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LivreServiceImpl implements LivreService {

    private final LivreRepository repository;

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
    public Livre save(Livre livre) {
        return repository.save(livre);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        repository.deleteById(isbn);
    }
}
