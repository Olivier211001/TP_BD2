package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOG")
@Getter
@Setter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
    @SequenceGenerator(name = "log_seq", sequenceName = "log_seq", allocationSize = 1)
    @Column(name="ID_LOG")
    private Long id;
    @Column(name="TYPE_OPERATION")
    private String typeOperation;
    @Column(name="DATE_OPERATION")
    private LocalDateTime dateOp;
    @Column(name="TABLE_VISEE")
    private String tableVisee;
    @Column(name="ID_LIGNE_MODIFIEE")
    private Long idLigneModifiee;

    @ManyToOne
    @JoinColumn(name="ID_EMP")
    private Employe employe;
}
