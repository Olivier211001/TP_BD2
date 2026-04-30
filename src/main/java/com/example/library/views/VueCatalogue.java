package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VUE_CATALOGUE")
public class VueCatalogue {

    @Id
    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "ANNEE")
    private Integer annee;

    @Column(name = "AUTEUR_NOM")
    private String auteurNom;

    @Column(name = "AUTEUR_PRENOM")
    private String auteurPrenom;

    @Column(name = "EDITEUR")
    private String editeur;

    @Column(name = "CATEGORIE")
    private String categorie;

    @Column(name = "NB_EXEMPLAIRES")
    private Integer nbExemplaires;

    @Column(name = "NB_DISPONIBLES")
    private Integer nbDisponibles;

    @Override
    public String toString() {
        return "\n========================================\n" +
                "LIVRE\n" +
                "----------------------------------------\n" +
                "ISBN         : " + isbn + "\n" +
                "Titre        : " + titre + "\n" +
                "Année        : " + annee + "\n" +
                "Auteur       : " + auteurPrenom + " " + auteurNom + "\n" +
                "Éditeur      : " + editeur + "\n" +
                "Catégorie    : " + categorie + "\n" +
                "----------------------------------------\n" +
                "En Stock\n" +
                "Total        : " + nbExemplaires + "\n" +
                "Disponibles  : " + nbDisponibles + "\n" +
                "========================================";
    }
}