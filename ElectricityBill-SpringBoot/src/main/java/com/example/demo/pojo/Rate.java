package com.example.demo.pojo;

import javax.persistence.*;
import java.util.*;

@Entity
public class Rate 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rateId;
	private String planName;
	private double price;
	
	@OneToMany
	private List<Consumer> consumers;
	
	public Rate() {}
	
	public Rate(String planName, double price) 
	{
		this.planName = planName;
		this.price = price;
	}

	public long getRateId() {
		return rateId;
	}

	public void setRateId(long rateId) {
		this.rateId = rateId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}
	
	
	

}
