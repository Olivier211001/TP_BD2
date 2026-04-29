package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
public class Transaction {

    @Id
    @Column(name = "ID_TRANS")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @SequenceGenerator(name = "transaction_seq", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_EMP", nullable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "ID_MEMBRE", nullable = false)
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "ID_EXEMPLAIRE", nullable = false)
    private Exemplaire exemplaire;

    @ManyToOne
    @JoinColumn(name = "ID_RES")
    private Reservation reservation;

    @Column(name = "DATE_DEBUT", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "DATE_RETOURPREVU", nullable = false)
    private LocalDate dateRetourPrevu;

    @Column(name = "DATE_RETOUREFFECTIVE")
    private LocalDate dateRetourEffective;

    @Enumerated(EnumType.STRING)
    @Column(name = "ETAT", length = 20)
    private EtatTransaction etat;

    public enum EtatTransaction {
        EnCours,
        Terminé,
        Annulé, EN_COURS
    }
}