package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "transaction_emprunt")
@Getter
@Setter
public class TransactionEmprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_emprunt_seq")
    @SequenceGenerator(name = "transaction_emprunt_seq", sequenceName = "transaction_emprunt_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private Membre membre;

    @ManyToOne
    private Exemplaire exemplaire;

    @ManyToOne
    private Reservation reservation; // nullable

    private LocalDate dateDebut;
    private LocalDate dateRetourPrevu;
    private LocalDate dateRetourEffective;

    @Enumerated(EnumType.STRING)
    private EtatTransaction etat;

    public enum EtatTransaction {
        EN_COURS, TERMINE, ANNULE
    }
}
