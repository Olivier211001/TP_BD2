package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EDITEUR")
@Getter
@Setter
public class Editeur {

    @Id
    @Column(name = "ID_EDIT")  // ← vraie PK dans Oracle
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editeur_seq")
    @SequenceGenerator(name = "editeur_seq", sequenceName = "SEQ_EDITEUR", allocationSize = 1)
    private Long id;

    @Column(name = "NOM", nullable = false, length = 100)
    private String nom;

    @Column(name = "ADRESSE", length = 200)
    private String adresse;

    @Column(name = "COURRIEL", length = 100)
    private String courriel;

    @Column(name = "NUM_TEL", length = 20)
    private String numTel;
}