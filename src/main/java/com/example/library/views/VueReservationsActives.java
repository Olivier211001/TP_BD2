package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "VUE_RESERVATIONS_ACTIVES")
public class VueReservationsActives {

    @Id
    @Column(name = "ID_RES")
    private Long idRes;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NUM_TEL")
    private String numTel;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "DATE_DEBUT")
    private LocalDate dateDebut;

    @Column(name = "DATE_FIN")
    private LocalDate dateFin;

    @Column(name = "ETAT")
    private String etat;

    @Override
    public String toString() {
        return "Réservation " + idRes +
                " | " + prenom + " " + nom +
                " | Livre: " + titre +
                " | ISBN: " + isbn +
                " | Début: " + dateDebut +
                " | Fin: " + dateFin +
                " | État: " + etat;
    }
}