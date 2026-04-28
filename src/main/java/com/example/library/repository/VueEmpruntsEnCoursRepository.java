package com.example.library.repository;

import com.example.library.views.VueEmpruntsEnCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueEmpruntsEnCoursRepository
        extends JpaRepository<VueEmpruntsEnCours, Long> {

}