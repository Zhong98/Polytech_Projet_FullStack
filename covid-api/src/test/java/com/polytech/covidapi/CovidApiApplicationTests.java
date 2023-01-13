package com.polytech.covidapi;

import com.polytech.covidapi.entity.Center;
import com.polytech.covidapi.repository.CenterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CovidApiApplicationTests {

	@Autowired
	CenterRepository centerRepository;
	@Test
	void contextLoads() {
		List<Center> all = centerRepository.findAll();
		System.out.println(all.size());
	}

}
