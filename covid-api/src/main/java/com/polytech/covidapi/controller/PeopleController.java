package com.polytech.covidapi.controller;

import com.polytech.covidapi.entity.Person;
import com.polytech.covidapi.service.admin.CRUDPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/people")
public class PeopleController {
    @Autowired
    CRUDPeople crudPeople;
    @GetMapping("/findDoctor")
    @ResponseBody
    public List<Person> findAllDoctors(String centerID){
        return crudPeople.getAllDoctors(centerID,2);
    }

    @GetMapping("/findAdmin")
    @ResponseBody
    public List<Person> findAdmins(){
        return crudPeople.getAdmins(1);
    }

    @GetMapping("/findSuperAdmin")
    @ResponseBody
    public List<Person> findSuperAdmins(){
        return crudPeople.getAdmins(0);
    }

    @PostMapping("/addOrUpdatePerson")
    @ResponseBody
    public int addPerson(@RequestBody Person person){
        boolean b = crudPeople.updatePerson(person);
        if (b) return 200;
        else return 400;
    }

    @GetMapping("/deletePerson")
    @Transactional
    @ResponseBody
    public int deletePerson(int id){
        boolean b = crudPeople.deletePerson(id);
        if (b) return 200;
        else return 400;
    }
}
