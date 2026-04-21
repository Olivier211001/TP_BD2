package com.example.library.controller;

import com.example.library.model.TransactionEmprunt;
import com.example.library.service.TransactionEmpruntService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionEmpruntController {

    private final TransactionEmpruntService service;

    public TransactionEmpruntController(TransactionEmpruntService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransactionEmprunt> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionEmprunt> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TransactionEmprunt> create(@RequestBody TransactionEmprunt transaction) {
        TransactionEmprunt saved = service.save(transaction);
        return ResponseEntity.created(URI.create("/api/transactions/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionEmprunt> update(@PathVariable Long id,
            @RequestBody TransactionEmprunt transaction) {
        if (!service.findById(id).isPresent())
            return ResponseEntity.notFound().build();
        transaction.setId(id);
        return ResponseEntity.ok(service.save(transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
