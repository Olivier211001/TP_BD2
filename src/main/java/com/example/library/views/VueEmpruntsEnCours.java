package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VUE_EMPRUNTS_EN_COURS")
public class VueEmpruntsEnCours {

    @Id
    @Column(name = "ID_TRANS")
    private Long idTrans;

    private String nomMembre;
    private String titre;

    @Column(name = "DATE_EMPRUNT")
    private java.time.LocalDate dateEmprunt;
}