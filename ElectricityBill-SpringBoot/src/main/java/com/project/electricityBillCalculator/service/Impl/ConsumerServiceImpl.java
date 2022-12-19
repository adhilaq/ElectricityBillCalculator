package com.project.electricityBillCalculator.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.electricityBillCalculator.entity.Bill;
import com.project.electricityBillCalculator.entity.Consumer;
import com.project.electricityBillCalculator.entity.Rate;
import com.project.electricityBillCalculator.exceptions.UserNotFoundException;
import com.project.electricityBillCalculator.repos.BillRepository;
import com.project.electricityBillCalculator.repos.ConsumerRepository;
import com.project.electricityBillCalculator.repos.RateRepository;
import com.project.electricityBillCalculator.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	ConsumerRepository consumerRepository;

	@Autowired
	BillRepository billRepository;

	@Autowired
	RateRepository rateRepository;
	
	public void addConsumer(@RequestBody Consumer consumer) {
		/*
		Optional<Rate> rate = rateRepository.findById(planId);
		Consumer consumer = new Consumer(consumerName, city, area, rate.get(), password, email);
		*/
		consumerRepository.save(consumer);
	}

	
	public ResponseEntity<String> registration(String email,String password) throws UserNotFoundException {
		Consumer consumer = consumerRepository.findByEmail(email);
		if (consumer == null)
			throw new UserNotFoundException("No Admin with email "+email+" is present");
		else {
			if (consumer.getPassword().equals(password))
				return new ResponseEntity<String>("Successfully logged in", HttpStatus.OK);
			else 
				return new ResponseEntity<String>("Username or password is incorrect", HttpStatus.BAD_REQUEST);
		}

	}

	public Iterable<Bill> getBillById(String consumerEmail)
			throws UserNotFoundException {
		Iterable<Bill> c1 = billRepository.findByConsumerEmail(consumerEmail);
		if (c1.iterator().hasNext())
			return c1;
		else {
			throw new UserNotFoundException("No Bill can be found with the email address:" + consumerEmail);
		}

	}



}
