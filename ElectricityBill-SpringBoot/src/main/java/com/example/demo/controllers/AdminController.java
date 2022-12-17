package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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


@RestController
public class AdminController 
{
	
	@Autowired
	ConsumerRepository consumerRepository;
	
	@Autowired
	BillRepository billRepository;
	
	@PostMapping("/bills")
	public void addBill(@RequestParam("year") int year, @RequestParam("month") int month, 
			@RequestParam("unitsConsumed") int unitsConsumed, @RequestParam("consumerId") long consumerId)
	{
		Optional<Consumer> consumer = consumerRepository.findById(consumerId);
		Rate rate = consumer.get().getPlanType();
		Bill bill = new Bill(year, month, unitsConsumed, 0, consumer.get());
		bill.setTotalBill(unitsConsumed*rate.getPrice());
		billRepository.save(bill);
	}
	
	@GetMapping("/consumers")
	public Iterable<Bill> getAllConsumerBill()
	{
		return billRepository.findAll();
	}

	
	@GetMapping("/consumers/city")
	public Iterable<Bill> getConsumerBillByCity(@RequestParam("city") String city)
	{	
		Iterable<Bill> bills = billRepository.findBillsByCity(city);		
		return bills;
	}
	@GetMapping("/consumers/area")
	public Iterable<Bill> getConsumerBillByArea(@RequestParam("area") String area)
	{	
		Iterable<Bill> bills = billRepository.findBillsByArea(area);		
		return bills;
	}
	
	@GetMapping("/consumers/date")
	public Iterable<Bill> getConsumerBillByYearAndMonth(@RequestParam("year") int year, @RequestParam("month") int month)
	{	
		Iterable<Bill> bills = billRepository.findBillsByYearAndMonth(year, month);		
		return bills;
	}
	
	
}
