package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "VUE_HISTORIQUE_MEMBRE")
public class VueHistoriqueMembre {

    @Id
    @Column(name = "ID_MEMBRE")
    private Long idMembre;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "DATE_DEBUT")
    private LocalDate dateDebut;

    @Column(name = "DATE_RETOURPREVU")
    private LocalDate dateRetourPrevu;

    @Column(name = "DATE_RETOUREFFECTIVE")
    private LocalDate dateRetourEffective;

    @Column(name = "ETAT_EMPRUNT")
    private String etatEmprunt;

    @Column(name = "ETAT_RESERVATION")
    private String etatReservation;

    @Column(name = "MONTANT_PENALITE")
    private Double montantPenalite;

    @Override
    public String toString() {
        return "Membre " + idMembre +
                " | " + prenom + " " + nom +
                " | Livre: " + titre +
                " | Début: " + dateDebut +
                " | Retour prévu: " + dateRetourPrevu +
                " | Retour effectif: " + dateRetourEffective +
                " | Emprunt: " + etatEmprunt +
                " | Réservation: " + etatReservation +
                " | Pénalité: " + montantPenalite;
    }
}