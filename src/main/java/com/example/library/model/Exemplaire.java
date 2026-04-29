package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "EXEMPLAIRE")
@Getter
@Setter
public class Exemplaire {

    @Id
    @Column(name = "ID_EXEMPLAIRE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exemplaire_seq")
    @SequenceGenerator(name = "exemplaire_seq", sequenceName = "EXEMPLAIRE_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ISBN", nullable = false)
    private Livre livre;

    @Enumerated(EnumType.STRING)
    @Column(name = "ETAT", length = 20)
    private EtatExemplaire etat;

    @Column(name = "DATE_ACQUISITION", nullable = false)
    private LocalDate dateAcquisition;

    public enum EtatExemplaire {
        Disponible,
        Emprunté,
        Perdu
    }
}