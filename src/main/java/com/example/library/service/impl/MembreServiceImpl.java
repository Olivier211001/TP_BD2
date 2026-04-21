package com.example.library.service.impl;

import com.example.library.model.Membre;
import com.example.library.repository.MembreRepository;
import com.example.library.service.MembreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembreServiceImpl implements MembreService {

    private final MembreRepository membreRepository;

    public MembreServiceImpl(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    @Override
    public List<Membre> findAll() {
        return membreRepository.findAll();
    }

    @Override
    public Optional<Membre> findById(Long id) {
        return membreRepository.findById(id);
    }

    @Override
    public Membre save(Membre membre) {
        return membreRepository.save(membre);
    }

    @Override
    public void deleteById(Long id) {
        membreRepository.deleteById(id);
    }
}
