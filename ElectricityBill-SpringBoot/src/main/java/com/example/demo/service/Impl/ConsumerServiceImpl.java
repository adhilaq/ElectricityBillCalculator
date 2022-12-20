package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Consumer;
import com.example.demo.entity.Rate;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repos.BillRepository;
import com.example.demo.repos.ConsumerRepository;
import com.example.demo.repos.RateRepository;
import com.example.demo.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	ConsumerRepository consumerRepository;

	@Autowired
	BillRepository billRepository;

	@Autowired
	RateRepository rateRepository;
	
	public void addConsumer(Consumer consumer) 
	{
		Optional<Rate> rate = rateRepository.findById(consumer.getPlanType().getRateId());
		consumer.setPlanType(rate.get());

		consumerRepository.save(consumer);
	}

	
	public ResponseEntity<String> registration(String email,String password) throws UserNotFoundException {
		Consumer consumer = consumerRepository.findByEmail(email);
		if (consumer == null)
			throw new UserNotFoundException("No Admin with email "+email+" is present");
		else {
			if (consumer.getPassword().equals(password)) {
				return new ResponseEntity<String>("Successfully logged in", HttpStatus.OK);
			}
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
