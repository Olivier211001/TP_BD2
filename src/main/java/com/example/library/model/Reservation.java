package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
public class Reservation {

    @Id
    @Column(name = "ID_RES")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq", sequenceName = "RESERVATION_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_MEMBRE", nullable = false)
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "ISBN", nullable = false)
    private Livre livre;

    @Column(name = "DATE_DEBUT", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "DATE_FIN", nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "ETAT", length = 20)
    private EtatReservation etat;

    public enum EtatReservation {
        Réservé,
        Annulé,
        Terminé
    }
}