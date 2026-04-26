package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "editeur")
@Getter
@Setter
public class Editeur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editeur_seq")
    @SequenceGenerator(name = "editeur_seq", sequenceName = "editeur_seq", allocationSize = 1)
    private Long id;

    private String nom;
    private String adresse;
    private String courriel;
    private String numTel;
}
