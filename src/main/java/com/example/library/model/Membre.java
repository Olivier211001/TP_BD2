package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MEMBRE")
@Getter
@Setter
public class Membre {

    @Id
    @Column(name = "ID_MEMBRE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membre_seq")
    @SequenceGenerator(name = "membre_seq", sequenceName = "MEMBRE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @Column(name = "ADRESSE", length = 200)
    private String adresse;

    @Column(name = "NUM_TEL", length = 20)
    private String numTel;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUT_COMPTE", length = 20)
    private StatutCompte statutCompte;

    @Column(name = "PASSWORD", nullable = false, length = 200)
    private String password;

    public enum StatutCompte {
        Actif,
        Inactif,
        Suspendu
    }
}