package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Membre membre;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private TransactionEmprunt transaction;

    private LocalDate datePay;

    @Enumerated(EnumType.STRING)
    private StatutPay statut;

    private BigDecimal montant;

    public enum StatutPay {
        PAYE, EN_ATTENTE
    }
}
