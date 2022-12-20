package com.example.demo.controllers;

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

import com.example.demo.entity.Bill;
import com.example.demo.entity.Consumer;
import com.example.demo.entity.Rate;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repos.BillRepository;
import com.example.demo.repos.ConsumerRepository;
import com.example.demo.repos.RateRepository;
import com.example.demo.service.Impl.ConsumerServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ConsumerController {

	@Autowired
	ConsumerServiceImpl consumerService;
<<<<<<< HEAD:ElectricityBill-SpringBoot/src/main/java/com/project/electricityBillCalculator/controllers/ConsumerController.java

=======
	
>>>>>>> 837cb2701c9d7c8d0e669d8ccd3c4751c61eb26c:ElectricityBill-SpringBoot/src/main/java/com/example/demo/controllers/ConsumerController.java
	@PostMapping("/consumers")
	public void addConsumer(@RequestBody Consumer consumer) {
		consumerService.addConsumer(consumer);
	}


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
