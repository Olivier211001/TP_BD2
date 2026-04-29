package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VUE_EMPLOYES")
public class VueEmployes {

    @Id
    @Column(name = "ID_EMP")
    private Long idEmp;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "ADRESSE")
    private String adresse;

    @Column(name = "NUM_TEL")
    private String numTel;

    @Column(name = "TYPE")
    private String type;

    @Override
    public String toString() {
        return "ID: " + idEmp +
                " | " + prenom + " " + nom +
                " | Type: " + type +
                " | Tel: " + numTel;
    }
}