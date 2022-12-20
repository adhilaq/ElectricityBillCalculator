package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Consumer;
import com.example.demo.exceptions.UserNotFoundException;

public interface ConsumerService {
	public void addConsumer(Consumer consumer);
	
	public ResponseEntity<String> registration(String email,String password) throws UserNotFoundException;
	
	public Iterable<Bill> getBillById(String consumerEmail) throws UserNotFoundException;

}
