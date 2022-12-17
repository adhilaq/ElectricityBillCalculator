package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Bill;
import com.example.demo.pojo.Consumer;
import com.example.demo.pojo.Rate;
import com.example.demo.repos.BillRepository;
import com.example.demo.repos.ConsumerRepository;
import com.example.demo.repos.RateRepository;

@RestController
public class ConsumerController 
{	
	
	@Autowired
	ConsumerRepository consumerRepository;
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	RateRepository rateRepository;
	
	@PostMapping("/consumers")
	public void addConsumer(@RequestParam("consumerName") String consumerName, @RequestParam("city") String city, 
			@RequestParam("area") String area, @RequestParam("planId") long planId, @RequestParam("password") String password, 
			@RequestParam("email") String email)
	{
		Optional<Rate> rate = rateRepository.findById(planId);
		Consumer consumer = new Consumer(consumerName, city, area, rate.get(), password, email);
		consumerRepository.save(consumer);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> registration(@RequestParam("email")String email,@RequestParam("password")String password)
	{
		Consumer user=consumerRepository.findByEmail(email);
		if(user.getPassword().equals(password))
			return new ResponseEntity<>("Successfully logged in", HttpStatus.OK);
		else
			return new ResponseEntity<>("Username or password is incorrect",HttpStatus.BAD_REQUEST);
			
	}
	
	
	
	@GetMapping(value="/consumers/bill")
	public Iterable<Bill> getBillById(@RequestParam("consumerEmail") String consumerEmail)
	{
		Iterable<Bill> c1 = billRepository.findByConsumerEmail(consumerEmail);
		return c1;
		
	}

}
