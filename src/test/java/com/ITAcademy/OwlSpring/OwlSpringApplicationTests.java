package com.ITAcademy.OwlSpring;

import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;
import com.ITAcademy.OwlSpring.repository.ManufacturerRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OwlSpringApplicationTests {
	@Autowired
	ManufacturerRepository manufacturerRepository;
	@Before("start of test")
	public void init() {
		System.out.println("startup");

	}
	@Test
	void contextLoads() {
	}
	@Test
	public void populateManufacturerTable(){
		manufacturerRepository.save(new ManufacturerEntity("Ford"));
		manufacturerRepository.save(new ManufacturerEntity("Sonic"));
	}
	@Test
	public void createCatalogModel(){

	}

	@After("end of test")
	public void teardown(){
		System.out.println("teardown");
	}

}
