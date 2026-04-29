package com.example.library.controller;

import com.example.library.model.Transaction;
import com.example.library.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionEmpruntController {

    private final TransactionService service;

    public TransactionEmpruntController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transaction> create(
            @RequestBody Transaction transaction) {

        if (transaction.getEmploye() == null
                || transaction.getMembre() == null
                || transaction.getExemplaire() == null
                || transaction.getDateDebut() == null
                || transaction.getDateRetourPrevu() == null) {

            return ResponseEntity.badRequest().build();
        }

        if (transaction.getEtat() == null) {
            transaction.setEtat(
                    Transaction.EtatTransaction.EN_COURS);
        }

        Transaction saved = service.save(transaction);

        return ResponseEntity
                .created(URI.create("/api/transactions/" + saved.getId()))
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(
            @PathVariable Long id,
            @RequestBody Transaction transaction) {

        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (transaction.getEmploye() == null
                || transaction.getMembre() == null
                || transaction.getExemplaire() == null
                || transaction.getDateDebut() == null
                || transaction.getDateRetourPrevu() == null) {

            return ResponseEntity.badRequest().build();
        }

        if (transaction.getEtat() == null) {
            transaction.setEtat(
                    Transaction.EtatTransaction.EN_COURS);
        }

        transaction.setId(id);

        return ResponseEntity.ok(service.save(transaction));
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