package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.exceptions.NotAuthorizedException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repos.BillRepository;
import com.example.demo.repos.ConsumerRepository;
import com.example.demo.service.Impl.AdminServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminController {

	@Autowired
	AdminServiceImpl adminService;

	@PostMapping("/bills")
	public void addBill(@RequestBody Bill bill) {
		adminService.addBill(bill);
	}

	@GetMapping("/consumers")
	public Iterable<Bill> getAllConsumerBill() throws UserNotFoundException {
		return adminService.getAllConsumerBill();
	}

	@GetMapping("/consumers/city")
	public Iterable<Bill> getConsumerBillByCity(@RequestParam("city") String city) throws UserNotFoundException {
		return adminService.getConsumerBillByCity(city);
	}

	@GetMapping("/consumers/area")
	public Iterable<Bill> getConsumerBillByArea(@RequestParam("area") String area) throws UserNotFoundException {
		return adminService.getConsumerBillByArea(area);
	}

	@GetMapping("/consumers/date")
	public Iterable<Bill> getConsumerBillByYearAndMonth(@RequestParam("year") int year,
			@RequestParam("month") int month) throws UserNotFoundException {
		return adminService.getConsumerBillByYearAndMonth(year, month);

	}
	
	@PostMapping("/login")
	public ResponseEntity<String> registration(@RequestParam("email") String email,
			@RequestParam("password") String password) throws UserNotFoundException, NotAuthorizedException {
		return adminService.registration(email, password);

	}

}
