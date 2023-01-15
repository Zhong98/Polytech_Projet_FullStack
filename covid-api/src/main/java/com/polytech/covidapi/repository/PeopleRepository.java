package com.polytech.covidapi.repository;

import com.polytech.covidapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<Person,Integer> {
    List<Person> findPeopleByCenterIDAndRole(String centerID,int role);
    List<Person> findPeopleByRole(int role);
    Person deletePersonById(int id);
    Person findPersonByEmail(String email);
    Person findPersonById(int id);
}
