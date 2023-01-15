package com.polytech.covidapi.repository;

import com.polytech.covidapi.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<Center,Integer> {
    List<Center> findCentersByCityLike(String city);
    Center findCenterById(Integer id);
    List<Center> findCentersByZipcode(String zipcode);
}
