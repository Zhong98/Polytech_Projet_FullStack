package com.polytech.covidapi.repository;

import com.polytech.covidapi.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findReservationsByCenterID(String centerID);
    List<Reservation> findReservationsByDateAndCenterID(String date,String centerID);
    Reservation deleteReservationById(int id);
}
