package com.polytech.covidapi.controller;

import com.polytech.covidapi.entity.Center;
import com.polytech.covidapi.entity.Reservation;
import com.polytech.covidapi.service.pub.Reserve;
import com.polytech.covidapi.service.pub.SearchCenter;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/public")
public class PublicController {
    @Autowired
    SearchCenter searchCenter;
    @GetMapping("/search")
    @Timed(value = "publicSearch",
            description = "public user search",
            percentiles={0.5,0.9,0.99})
    @Counted(value = "publicSearchCounted",description = "Nombre de recherches")
    @ResponseBody
    public List<Center> search(@RequestParam("centerInfo") String cityOrZIPcode){
        return searchCenter.getCenters(cityOrZIPcode);
    }

    @Autowired
    Reserve reserve;
    @PostMapping("/reserve")
    @Timed(value = "publicReserve",
            description = "public user reserve",
            percentiles={0.5,0.9,0.99})
    @Counted(value = "publicReserveCounted",description = "Nombre de prendre rdv")
    @ResponseBody
    public int reserve(@RequestBody Reservation reservation){
        System.out.println(reservation);
        boolean b = reserve.addReservation(reservation);
        if (b) return 200;
        else return 400;
    }
}
