package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYE")
@Getter
@Setter
public class Employe {

    @Id
    @Column(name = "ID_EMP")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employe_seq")
    @SequenceGenerator(name = "employe_seq", sequenceName = "EMPLOYE_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Column(name = "PRENOM", nullable = false, length = 50)
    private String prenom;

    @Column(name = "ADRESSE", length = 200)
    private String adresse;

    @Column(name = "NUM_TEL", length = 20)
    private String numTel;

    
    @Column(name = "TYPE", nullable = false, length = 20)
    private String type;

}