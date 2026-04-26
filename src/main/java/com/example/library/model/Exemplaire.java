package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "exemplaire")
@Getter
@Setter
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exemplaire_seq")
    @SequenceGenerator(name = "exemplaire_seq", sequenceName = "exemplaire_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Livre livre;

    @Enumerated(EnumType.STRING)
    private EtatExemplaire etat;

    private LocalDate dateAcquisition;

    public enum EtatExemplaire {
        DISPONIBLE, EMPRUNTE, PERDU
    }
}
