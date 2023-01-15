package com.polytech.covidapi.service.pub;

import com.polytech.covidapi.entity.Reservation;
import com.polytech.covidapi.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reserve {
    @Autowired
    ReserveRepository reserveRepository;

    public boolean addReservation(Reservation reservation){
        try {
            reserveRepository.save(reservation);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
