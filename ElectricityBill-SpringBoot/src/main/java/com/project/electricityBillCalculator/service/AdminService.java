package com.project.electricityBillCalculator.service;

import com.project.electricityBillCalculator.entity.Bill;
import com.project.electricityBillCalculator.exceptions.UserNotFoundException;

public interface AdminService {
	public void addBill(Bill bill) ;
	public Iterable<Bill> getAllConsumerBill() throws UserNotFoundException ;
	public Iterable<Bill> getConsumerBillByCity(String city) throws UserNotFoundException ;
	public Iterable<Bill> getConsumerBillByArea(String area) throws UserNotFoundException ;
	public Iterable<Bill> getConsumerBillByYearAndMonth(int year,int month) throws UserNotFoundException ;

}
