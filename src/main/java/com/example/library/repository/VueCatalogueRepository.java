package com.example.library.repository;

import com.example.library.views.VueCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueCatalogueRepository
        extends JpaRepository<VueCatalogue, String> {

}