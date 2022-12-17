package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.pojo.Rate;
import com.example.demo.repos.RateRepository;

@SpringBootApplication
public class ElectricityBillSpringBootApplication //implements CommandLineRunner
{

	@Autowired
	RateRepository rateRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillSpringBootApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception 
//	{
//		rateRepository.save(new Rate("Domestic", 2));
//		rateRepository.save(new Rate("Commercial", 4));
//		System.out.println("Data inserted.");
//		
//	}

}
