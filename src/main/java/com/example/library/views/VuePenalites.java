package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VUE_PENALITES")
public class VuePenalites {

    @Id
    @Column(name = "ID_PAY")
    private Long idPay;

    private String nom;

    @Column(name = "MONTANT")
    private Double montant;
}
