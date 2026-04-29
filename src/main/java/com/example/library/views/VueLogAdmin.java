package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "VUE_LOG_ADMIN")
public class VueLogAdmin {

    @Id
    @Column(name = "ID_LOG")
    private Long idLog;

    @Column(name = "TYPE_OPERATION")
    private String typeOperation;

    @Column(name = "DATE_OPERATION")
    private LocalDate dateOperation;

    @Column(name = "TABLE_VISEE")
    private String tableVisee;

    @Column(name = "ID_LIGNE_MODIFIEE")
    private Long idLigneModifiee;

    @Column(name = "EMPLOYE_NOM")
    private String employeNom;

    @Column(name = "EMPLOYE_PRENOM")
    private String employePrenom;

    @Column(name = "EMPLOYE_TYPE")
    private String employeType;

    @Override
    public String toString() {
        return "Log " + idLog +
                " | " + typeOperation +
                " sur " + tableVisee +
                " | Ligne " + idLigneModifiee +
                " | " + employePrenom + " " + employeNom +
                " (" + employeType + ")";
    }
}