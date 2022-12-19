package com.project.electricityBillCalculator.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.electricityBillCalculator.entity.Bill;
import com.project.electricityBillCalculator.entity.Consumer;
import com.project.electricityBillCalculator.exceptions.UserNotFoundException;

public interface ConsumerService {
	public void addConsumer(Consumer consumer);
	
	public ResponseEntity<String> registration(String email,String password) throws UserNotFoundException;
	
	public Iterable<Bill> getBillById(String consumerEmail) throws UserNotFoundException;

}
