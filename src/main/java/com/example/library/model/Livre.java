package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @Column(name = "TITRE", length = 100, nullable = false)
    private String titre;

    @Column(name = "ANNEE", nullable = false)
    private Integer annee;

    // ID_EDIT est la vraie FK dans la table Oracle (NOT NULL)
    @ManyToOne
    @JoinColumn(name = "ID_EDIT", nullable = false)
    @JsonIgnoreProperties({"livres"})
    private Editeur editeur;

    // ID_CAT est la vraie FK dans la table Oracle (NOT NULL)
    @ManyToOne
    @JoinColumn(name = "ID_CAT", nullable = false)
    @JsonIgnoreProperties({"livres"})
    private Categorie categorie;

    @ManyToMany
    @JoinTable(
            name = "LIVREAUTEUR",
            joinColumns = @JoinColumn(name = "ISBN"),
            inverseJoinColumns = @JoinColumn(name = "ID_AUTEUR")
    )
    @JsonIgnoreProperties({"livres"})
    private Set<Auteur> auteurs = new HashSet<>();
}