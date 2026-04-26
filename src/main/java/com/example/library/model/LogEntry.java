package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "log_entry")
@Getter
@Setter
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_entry_seq")
    @SequenceGenerator(name = "log_entry_seq", sequenceName = "log_entry_seq", allocationSize = 1)
    private Long id;

    private String typeOperation;
    private LocalDateTime dateOp;
    private String tableVisee;
    private Long idLigneModifiee;

    @ManyToOne
    private Employe employe;
}
