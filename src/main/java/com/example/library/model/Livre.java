package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LIVRE")
@Getter
@Setter
public class Livre {

    @Id
    @Column(name = "ISBN", length = 20)
    private String isbn;

    @Column(name = "TITRE", nullable = false, length = 100)
    private String titre;

    @Column(name = "ANNEE", nullable = false)
    private Integer annee;

    @ManyToOne
    @JoinColumn(name = "ID_EDIT", nullable = false)
    private Editeur editeur;

    @ManyToOne
    @JoinColumn(name = "ID_CAT", nullable = false)
    private Categorie categorie;

    @ManyToMany
    @JoinTable(name = "LIVREAUTEUR", joinColumns = @JoinColumn(name = "ISBN"), inverseJoinColumns = @JoinColumn(name = "ID_AUTEUR"))
    private Set<Auteur> auteurs = new HashSet<>();
}