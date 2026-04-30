package com.example.library.views;

import jakarta.persistence.*;
import lombok.Getter;

import org.hibernate.annotations.Immutable;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "VUE_PENALITES")
@Getter
public class VuePenalites {

    @Id
    @Column(name = "ID_PAY")
    private Long idPay;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "DATE_RETOURPREVU")
    private LocalDate dateRetourPrevu;

    @Column(name = "DATE_RETOUREFFECTIVE")
    private LocalDate dateRetourEffective;

    @Column(name = "MONTANT")
    private Double montant;

    @Column(name = "STATUT")
    private String statut;

    @Column(name = "DATE_PAY")
    private LocalDate datePay;

    @Override
    public String toString() {
        return "Pénalité " + idPay +
                " | " + prenom + " " + nom +
                " | Livre: " + titre +
                " | Montant: " + montant +
                " | Statut: " + statut +
                " | Date paiement: " + datePay;
    }
}