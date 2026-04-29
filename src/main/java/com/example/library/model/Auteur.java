package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AUTEUR")
@Getter
@Setter
public class Auteur {

    @Id
    @Column(name = "ID_AUTEUR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auteur_seq")
    @SequenceGenerator(name = "auteur_seq", sequenceName = "AUTEUR_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @Column(name = "BIOGRAPHIE", length = 500)
    private String biographie;
}