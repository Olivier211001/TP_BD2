package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "livre")
@Getter
@Setter
public class Livre {
    @Id
    private String isbn;

    private String titre;

    private Integer annee;

    @ManyToOne
    private Editeur editeur;

    @ManyToOne
    private Categorie categorie;

    @ManyToMany
    @JoinTable(name = "livre_auteur", joinColumns = @JoinColumn(name = "livre_isbn"), inverseJoinColumns = @JoinColumn(name = "auteur_id"))
    private Set<Auteur> auteurs = new HashSet<>();
}
