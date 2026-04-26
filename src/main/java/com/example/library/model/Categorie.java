package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CATEGORIE")
@Getter
@Setter
public class Categorie {

    @Id
    @Column(name = "ID_CAT")  // ← vraie PK dans Oracle
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorie_seq")
    @SequenceGenerator(name = "categorie_seq", sequenceName = "SEQ_CATEGORIE", allocationSize = 1)
    private Long id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "DESCRIPTION", length = 200)
    private String description;
}