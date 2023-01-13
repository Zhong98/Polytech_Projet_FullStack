package com.polytech.covidapi.repository;

import com.polytech.covidapi.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Center,Long> {
}
