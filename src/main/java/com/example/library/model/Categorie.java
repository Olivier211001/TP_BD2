package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorie")
@Getter
@Setter
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorie_seq")
    @SequenceGenerator(name = "categorie_seq", sequenceName = "categorie_seq", allocationSize = 1)
    private Long id;

    private String nom;
    private String description;
}
