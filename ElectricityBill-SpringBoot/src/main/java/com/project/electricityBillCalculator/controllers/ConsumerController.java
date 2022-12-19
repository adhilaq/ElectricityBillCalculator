package com.project.electricityBillCalculator.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.electricityBillCalculator.entity.Bill;
import com.project.electricityBillCalculator.entity.Consumer;
import com.project.electricityBillCalculator.entity.Rate;
import com.project.electricityBillCalculator.exceptions.UserNotFoundException;
import com.project.electricityBillCalculator.repos.BillRepository;
import com.project.electricityBillCalculator.repos.ConsumerRepository;
import com.project.electricityBillCalculator.repos.RateRepository;
import com.project.electricityBillCalculator.service.Impl.ConsumerServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ConsumerController {

	@Autowired
	ConsumerServiceImpl consumerService;
/*
	@PostMapping("/consumers")
	public void addConsumer(@RequestParam("consumerName") String consumerName, @RequestParam("city") String city,
			@RequestParam("area") String area, @RequestParam("planId") long planId,
			@RequestParam("password") String password, @RequestParam("email") String email) {
		Optional<Rate> rate = rateRepository.findById(planId);
		Consumer consumer = new Consumer(consumerName, city, area, rate.get(), password, email);
		consumerRepository.save(consumer);
	}
	*/

	@PostMapping("/login")
	public ResponseEntity<String> registration(@RequestParam("email") String email,
			@RequestParam("password") String password) throws UserNotFoundException {
		return consumerService.registration(email, password);

	}

	@GetMapping(value = "/consumers/bill")
	public Iterable<Bill> getBillById(@RequestParam("consumerEmail") String consumerEmail)
			throws UserNotFoundException {
		return consumerService.getBillById(consumerEmail);

	}

}
