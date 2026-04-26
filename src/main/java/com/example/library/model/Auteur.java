package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "auteur")
@Getter
@Setter
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auteur_seq")
    @SequenceGenerator(name = "auteur_seq", sequenceName = "auteur_seq", allocationSize = 1)
    private Long id;

    private String nom;
    private String prenom;
    @Column(length = 2000)
    private String biographie;
}
