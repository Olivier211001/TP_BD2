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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
