package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "PAIEMENT")
@Getter
@Setter
public class Paiement {

    @Id
    @Column(name = "ID_PAY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paiement_seq")
    @SequenceGenerator(name = "paiement_seq", sequenceName = "PAIEMENT_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_MEMBRE", nullable = false)
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "ID_EMP", nullable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "ID_TRANS", nullable = false)
    private Transaction transaction;

    @Column(name = "DATE_PAY", nullable = false)
    private LocalDate datePay;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUT", length = 20)
    private StatutPaiement statut;

    @Column(name = "MONTANT", nullable = false)
    private Double montant;

    public enum StatutPaiement {
        EnAttente,
        Payé,
        Annulé
    }
}