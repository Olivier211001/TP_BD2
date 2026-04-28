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

    @Column(name = "AUTEUR")
    private String auteur;

    @Column(name = "EDITEUR")
    private String editeur;

    @Column(name = "CATEGORIE")
    private String categorie;

    @Column(name = "NB_DISPONIBLES")
    private Integer nbDisponibles;

    // getters/setters
}