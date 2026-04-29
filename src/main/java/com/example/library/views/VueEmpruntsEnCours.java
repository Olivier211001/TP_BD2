package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "VUE_EMPRUNTS_EN_COURS")
public class VueEmpruntsEnCours {

    @Id
    @Column(name = "ID_TRANS")
    private Long idTrans;

    @Column(name = "MEMBRE_NOM")
    private String membreNom;

    @Column(name = "MEMBRE_PRENOM")
    private String membrePrenom;

    @Column(name = "NUM")
    private String num;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "ID_EXEMPLAIRE")
    private Long idExemplaire;

    @Column(name = "DATE_DEBUT")
    private LocalDate dateDebut;

    @Column(name = "DATE_RETOURPREVU")
    private LocalDate dateRetourPrevu;

    @Column(name = "ETAT")
    private String etat;

    @Column(name = "EMPLOYE_NOM")
    private String employeNom;

    @Override
    public String toString() {
        return "Transaction " + idTrans +
                " | " + membrePrenom + " " + membreNom +
                " | Livre: " + titre +
                " | Retour prévu: " + dateRetourPrevu +
                " | Etat: " + etat;
    }
}