package com.polytech.covidapi.service.admin;

import com.polytech.covidapi.entity.Person;
import com.polytech.covidapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDPeople {
    @Autowired
    PeopleRepository peopleRepository;

    public List<Person> getAllDoctors(String centerID,int role){
        return peopleRepository.findPeopleByCenterIDAndRole(centerID, role);
    }

    public List<Person> getAdmins(int role){
        return peopleRepository.findPeopleByRole(role);
    }

    public boolean updatePerson(Person person){
        try {
            peopleRepository.save(person);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletePerson(int id){
        try {
            peopleRepository.deletePersonById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
