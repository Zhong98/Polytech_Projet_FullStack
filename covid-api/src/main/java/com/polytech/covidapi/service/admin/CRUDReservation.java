package com.polytech.covidapi.service.admin;

import com.polytech.covidapi.entity.Reservation;
import com.polytech.covidapi.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CRUDReservation {
    @Autowired
    ReserveRepository reserveRepository;

    public List<Reservation> getReservationsByCenter(String centerID){
        return reserveRepository.findReservationsByCenterID(centerID);
    }

    public List<Reservation> getReservationsByDate(String date,String centerID){
        return reserveRepository.findReservationsByDateAndCenterID(date, centerID);
    }

    public List<Reservation> getReservationsByPatient(String date,String centerID,String name){
        List<Reservation> rdvs = reserveRepository.findReservationsByDateAndCenterID(date, centerID);
        List<Reservation> newList=new ArrayList<>();
        for (int i = 0; i < rdvs.size(); i++) {
            Reservation rdv=rdvs.get(i);
            if (rdv.getFirstname().equals(name) || rdv.getLastname().equals(name)){
                newList.add(rdv);
            }
        }
        return newList;
    }

    public boolean updateReservation(Reservation reservation){
        try {
            reserveRepository.save(reservation);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteReservation(int id){
        try {
            reserveRepository.deleteReservationById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
