package com.example.library.repository;

import com.example.library.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository 
        extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.membre.id = :idMembre " +
           "AND r.livre.isbn = :isbn AND r.etat = :etat")
    Optional<Reservation> findByMembreAndIsbnAndEtat(
        @Param("idMembre") Long idMembre,
        @Param("isbn") String isbn,
        @Param("etat") String etat);

    List<Reservation> findByMembreId(Long idMembre);
    List<Reservation> findByEtat(Reservation.EtatReservation etat);
}