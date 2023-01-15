package com.polytech.covidapi.controller;

import com.polytech.covidapi.entity.Reservation;
import com.polytech.covidapi.service.admin.CRUDReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/reservation")
public class ReservationController {
    @Autowired
    CRUDReservation crudReservation;

    @GetMapping("/findReservationByCenter")
    @ResponseBody
    public List<Reservation> findReservationByCenter(String centerID){
        return crudReservation.getReservationsByCenter(centerID);
    }

    @GetMapping("/findReservationByDate")
    @ResponseBody
    public List<Reservation> findReservationByDate(String date,String centerID){
        return crudReservation.getReservationsByDate(date,centerID);
    }

    @GetMapping("/findReservationByPatient")
    @ResponseBody
    public List<Reservation> findReservationByPatient(String date,String centerID,String name){
        System.out.println(name);
        return crudReservation.getReservationsByPatient(date,centerID,name);
    }

    @PostMapping("/updateReservation")
    @ResponseBody
    public int updateReservation(@RequestBody Reservation reservation){
        boolean b = crudReservation.updateReservation(reservation);
        if (b) return 200;
        else return 400;
    }

    @GetMapping("/deleteReservation")
    @Transactional
    @ResponseBody
    public int deleteReservation(int id){
        boolean b = crudReservation.deleteReservation(id);
        if (b) return 200;
        else return 400;
    }
}
