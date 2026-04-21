package com.example.library.controller;

import com.example.library.model.Membre;
import com.example.library.service.MembreService;
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

@WebMvcTest(MembreController.class)
public class MembreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MembreService membreService;

    @Test
    void getAllMembres_returnsList() throws Exception {
        Membre m = new Membre();
        m.setId(1L);
        m.setNom("Dupont");

        when(membreService.findAll()).thenReturn(List.of(m));

        mockMvc.perform(get("/api/membres"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nom").value("Dupont"));
    }
}
