package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billId;
	private int year;
	private int month;
	private int unitsConsumed;
	private double totalBill;

	@OneToOne
	@JoinColumn(name = "consumerId")
	private Consumer consumerId;
	
	public Bill() {}

	public Bill(int year, int month, int unitsConsumed, double totalBill, Consumer consumer) 
	{
		this.year = year;
		this.month = month;
		this.unitsConsumed = unitsConsumed;
		this.totalBill = totalBill;
		this.consumerId = consumer;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long id) {
		this.billId = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public Consumer getConsumer() {
		return consumerId;
	}

	public void setConsumer(Consumer consumer) {
		this.consumerId = consumer;
	}
	
}
