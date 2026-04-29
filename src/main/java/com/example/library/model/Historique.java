package com.example.library.model;

import jakarta.persistence.*;
import jakarta.transaction.Transaction;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "HISTORIQUE")
@Getter
@Setter
public class Historique {

    @Id
    @Column(name = "ID_HIST")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historique_seq")
    @SequenceGenerator(name = "historique_seq", sequenceName = "HISTORIQUE_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_TRANS")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "ID_MEMBRE")
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "ID_EMP")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "ID_RES")
    private Reservation reservation;

    @Column(name = "MONTANT_PENALITE")
    private BigDecimal montantPenalite;
}