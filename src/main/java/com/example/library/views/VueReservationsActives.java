package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VUE_RESERVATIONS_ACTIVES")
public class VueReservationsActives {

    @Id
    @Column(name = "ID_RES")
    private Long idRes;

    private String nom;
    private String titre;
}
