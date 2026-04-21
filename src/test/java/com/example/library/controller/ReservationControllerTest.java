package com.example.library.controller;

import com.example.library.model.Reservation;
import com.example.library.model.Membre;
import com.example.library.model.Livre;
import com.example.library.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    void getAllReservations_returnsList() throws Exception {
        Reservation r = new Reservation();
        r.setId(1L);
        Membre m = new Membre();
        m.setId(1L);
        m.setNom("Dupont");
        r.setMembre(m);
        Livre l = new Livre();
        l.setIsbn("978-0000000001");
        l.setTitre("Titre");
        r.setLivre(l);
        r.setDateDebut(LocalDate.now());
        r.setDateFin(LocalDate.now().plusDays(7));

        when(reservationService.findAll()).thenReturn(List.of(r));

        mockMvc.perform(get("/api/reservations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].membre.id").value(1));
    }
}
