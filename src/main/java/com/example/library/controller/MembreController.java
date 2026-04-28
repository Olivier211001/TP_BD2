package com.example.library.controller;

import com.example.library.model.Membre;
import com.example.library.service.MembreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/membres")
public class MembreController {

    private final MembreService service;

    public MembreController(MembreService service) {
        this.service = service;
    }

    @GetMapping
    public List<Membre> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membre> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Membre> create(@RequestBody Membre membre) {

        if (membre.getNom() == null || membre.getNom().isBlank()
                || membre.getPrenom() == null || membre.getPrenom().isBlank()
                || membre.getPassword() == null || membre.getPassword().isBlank()) {

            return ResponseEntity.badRequest().build();
        }

        if (membre.getStatutCompte() == null) {
            membre.setStatutCompte(Membre.StatutCompte.Actif);
        }

        Membre saved = service.save(membre);

        return ResponseEntity
                .created(URI.create("/api/membres/" + saved.getId()))
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membre> update(
            @PathVariable Long id,
            @RequestBody Membre membre) {

        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (membre.getNom() == null || membre.getNom().isBlank()
                || membre.getPrenom() == null || membre.getPrenom().isBlank()
                || membre.getPassword() == null || membre.getPassword().isBlank()) {

            return ResponseEntity.badRequest().build();
        }

        if (membre.getStatutCompte() == null) {
            membre.setStatutCompte(Membre.StatutCompte.Actif);
        }

        membre.setId(id);

        return ResponseEntity.ok(service.save(membre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}