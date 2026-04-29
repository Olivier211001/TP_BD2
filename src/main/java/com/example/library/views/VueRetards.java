package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "VUE_RETARDS")
public class VueRetards {

    @Id
    @Column(name = "ID_TRANS")
    private Long idTrans;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NUM_TEL")
    private String numTel;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "DATE_RETOURPREVU")
    private LocalDate dateRetourPrevu;

    @Column(name = "JOURS_RETARD")
    private Integer joursRetard;

    @Column(name = "PENALITE_ESTIMEE")
    private Double penaliteEstimee;

    @Override
    public String toString() {
        return "Retard " + idTrans +
                " | " + prenom + " " + nom +
                " | Livre: " + titre +
                " | Retard: " + joursRetard + " jours" +
                " | Pénalité estimée: " + penaliteEstimee;
    }
}