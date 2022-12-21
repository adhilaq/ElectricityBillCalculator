package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Consumer;
import com.example.demo.entity.Rate;
import com.example.demo.exceptions.NotAuthorizedException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repos.BillRepository;
import com.example.demo.repos.ConsumerRepository;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	ConsumerRepository consumerRepository;

	@Autowired
	BillRepository billRepository;

	public void addBill(Bill bill) {
		Optional<Consumer> consumer = consumerRepository.findById(bill.getConsumer().getConsumerId());
		Rate rate = consumer.get().getPlanType();
		bill.setConsumer(consumer.get());
		bill.setTotalBill(bill.getUnitsConsumed() * rate.getPrice());
		billRepository.save(bill);
	}

	public Iterable<Bill> getAllConsumerBill() throws UserNotFoundException {
		Iterable<Bill> bills = billRepository.findAll();
		if (bills.iterator().hasNext())
			return bills;
		else
			throw new UserNotFoundException("No bill data is present in the database");
	}

	public Iterable<Bill> getConsumerBillByCity(String city) throws UserNotFoundException {
		Iterable<Bill> bills = billRepository.findBillsByCity(city);
		if (bills.iterator().hasNext())
			return bills;
		else
			throw new UserNotFoundException("No bill can be found with city: " + city);
	}

	public Iterable<Bill> getConsumerBillByArea(String area) throws UserNotFoundException {
		Iterable<Bill> bills = billRepository.findBillsByArea(area);
		if (bills.iterator().hasNext())
			return bills;
		else
			throw new UserNotFoundException("No bill can be found with area: " + area);
	}

	public Iterable<Bill> getConsumerBillByYearAndMonth(int year, int month) throws UserNotFoundException {
		Iterable<Bill> bills = billRepository.findBillsByYearAndMonth(year, month);
		if (bills.iterator().hasNext())
			return bills;
		else
			throw new UserNotFoundException("No consumer bill can be found with year: " + year + " month: " + month);

	}

	@Override
	public ResponseEntity<String> registration(String email, String password)
			throws UserNotFoundException, NotAuthorizedException {
		
		Consumer consumer = consumerRepository.findByEmail(email);
		if (consumer == null)
			throw new UserNotFoundException("No Admin with email " + email + " is present");
		else {
			if (consumer.getPassword().equals(password)) {
				if (consumer.isAdmin())
					return new ResponseEntity<String>("Successfully logged in", HttpStatus.OK);
				else {
					throw new NotAuthorizedException(
							"Admin with the email: " + email + " is not present. Try to login as a User.");
				}
			} else
				return new ResponseEntity<String>("Username or password is incorrect", HttpStatus.BAD_REQUEST);
		}
	}

}
