package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "membre")
@Getter
@Setter
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membre_seq")
    @SequenceGenerator(name = "membre_seq", sequenceName = "membre_seq", allocationSize = 1)
    private Long id;

    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;

    @Enumerated(EnumType.STRING)
    private StatutCompte statutCompte;

    private String password;

    public enum StatutCompte {
        ACTIF, SUSPENDU, EXPIRE
    }
}
