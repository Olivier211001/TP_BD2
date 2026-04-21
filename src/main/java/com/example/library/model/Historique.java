package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "historique")
@Getter
@Setter
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TransactionEmprunt transaction;

    @ManyToOne
    private Membre membre;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private Reservation reservation;

    private BigDecimal montantPenalite;
}
