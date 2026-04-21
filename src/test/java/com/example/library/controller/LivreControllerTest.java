package com.example.library.controller;

import com.example.library.model.Livre;
import com.example.library.service.LivreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LivreController.class)
public class LivreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LivreService livreService;

    @Test
    void getAllLivres_returnsList() throws Exception {
        Livre l = new Livre();
        l.setIsbn("978-0000000001");
        l.setTitre("Test Livre");
        l.setAnnee(2020);

        when(livreService.findAll()).thenReturn(List.of(l));

        mockMvc.perform(get("/api/livres"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].isbn").value("978-0000000001"));
    }

    @Test
    void getLivreByIsbn_found() throws Exception {
        Livre l = new Livre();
        l.setIsbn("978-0000000001");
        l.setTitre("Test Livre");

        when(livreService.findByIsbn("978-0000000001")).thenReturn(java.util.Optional.of(l));

        mockMvc.perform(get("/api/livres/978-0000000001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titre").value("Test Livre"));
    }
}
