package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "consumer")
public class Consumer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long consumerId;
	private String consumerName;
	private String city;
	private String area;

	@JoinColumn(referencedColumnName = "rateId")
	@ManyToOne
	private Rate planType;
	
	private String password;
	private String email;
	private boolean isAdmin;
	
	//TODO
	@OneToMany
	private List<Bill> bills;
	
	public Consumer() {}
	
	public Consumer(String consumerName, String city, String area, Rate planType, String password,String email) 
	{
		this.consumerName = consumerName;
		this.city = city;
		this.area = area;
		this.planType = planType;
		this.password = password;
		this.email = email;
		this.isAdmin = false;
	}
	
	public long getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Rate getPlanType() {
		return planType;
	}
	public void setPlanType(Rate planType) {
		this.planType = planType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}	
	
	

	    
}
