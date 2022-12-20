package com.example.demo.service;

import com.example.demo.entity.Bill;
import com.example.demo.exceptions.UserNotFoundException;

public interface AdminService {
	public void addBill(Bill bill) ;
	public Iterable<Bill> getAllConsumerBill() throws UserNotFoundException ;
	public Iterable<Bill> getConsumerBillByCity(String city) throws UserNotFoundException ;
	public Iterable<Bill> getConsumerBillByArea(String area) throws UserNotFoundException ;
	public Iterable<Bill> getConsumerBillByYearAndMonth(int year,int month) throws UserNotFoundException ;

}
