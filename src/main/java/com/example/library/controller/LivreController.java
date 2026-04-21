package com.example.library.controller;

import com.example.library.model.Livre;
import com.example.library.service.LivreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService service;

    public LivreController(LivreService service) {
        this.service = service;
    }

    @GetMapping
    public List<Livre> all() {
        return service.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Livre> get(@PathVariable String isbn) {
        return service.findByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livre> create(@RequestBody Livre livre) {
        Livre saved = service.save(livre);
        return ResponseEntity.created(URI.create("/api/livres/" + saved.getIsbn())).body(saved);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Livre> update(@PathVariable String isbn, @RequestBody Livre livre) {
        if (!service.findByIsbn(isbn).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        livre.setIsbn(isbn);
        return ResponseEntity.ok(service.save(livre));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> delete(@PathVariable String isbn) {
        service.deleteByIsbn(isbn);
        return ResponseEntity.noContent().build();
    }
}
