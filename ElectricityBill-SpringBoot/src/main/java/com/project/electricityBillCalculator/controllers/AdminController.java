package com.project.electricityBillCalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.project.electricityBillCalculator.service.Impl.AdminServiceImpl;

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

}
