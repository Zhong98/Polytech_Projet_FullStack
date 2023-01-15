package com.polytech.covidapi;

import com.polytech.covidapi.entity.Center;
import com.polytech.covidapi.entity.Reservation;
import com.polytech.covidapi.repository.CenterRepository;
import com.polytech.covidapi.repository.ReserveRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CovidApiApplicationTests {

	@Autowired
	CenterRepository centerRepository;
	@Autowired
	ReserveRepository reserveRepository;
	@Test
	void contextLoads() {
	}
}
