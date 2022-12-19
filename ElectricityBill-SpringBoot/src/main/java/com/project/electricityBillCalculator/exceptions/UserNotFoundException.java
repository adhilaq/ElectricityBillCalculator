package com.project.electricityBillCalculator.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends Exception {

	
	public UserNotFoundException(String message)
	{
		super(message);
	}
	
}
