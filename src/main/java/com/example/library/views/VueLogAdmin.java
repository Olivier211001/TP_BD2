package com.example.library.views;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VUE_LOG_ADMIN")
public class VueLogAdmin {

    @Id
    @Column(name = "ID_LOG")
    private Long idLog;

    private String typeOperation;
}
