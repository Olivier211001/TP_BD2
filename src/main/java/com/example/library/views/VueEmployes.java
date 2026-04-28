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

    private String nom;
    private String poste;
}