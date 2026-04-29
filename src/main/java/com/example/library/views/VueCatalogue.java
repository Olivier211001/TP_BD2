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

    @Column(name = "NB_DISPONIBLES")
    private Integer nbDisponibles;

    @Override
    public String toString() {
        return "ISBN: " + isbn +
                " | Titre: " + titre +
                " | Disponibles: " + nbDisponibles;
    }
}