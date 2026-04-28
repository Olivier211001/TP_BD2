package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VUE_HISTORIQUE_MEMBRE")
public class VueHistoriqueMembre {

    @Id
    @Column(name = "ID_TRANS")
    private Long idTrans;

    private String nom;
    private String prenom;
    private String titre;
}
