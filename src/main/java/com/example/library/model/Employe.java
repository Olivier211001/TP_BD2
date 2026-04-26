package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employe")
@Getter
@Setter
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employe_seq")
    @SequenceGenerator(name = "employe_seq", sequenceName = "employe_seq", allocationSize = 1)
    private Long id;

    private String nom;
    private String prenom;
    private String adresse;
    private String numTel;

    @Enumerated(EnumType.STRING)
    private TypeEmploye type;

    public enum TypeEmploye {
        ADMIN, BIBLIOTHECAIRE
    }
}
