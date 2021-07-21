package com.techelevator.exceptions;

// To define your own custom Exceptions
//		1. create a class that extends Exception
//		2. provide an optional default constructor that calls Exception constructor
//		3. provide any other constructor you want, it still must call the Exception constructor

public class OverdraftException extends Exception {

	private double overdraftAmount = 0;	// an optional member variable that can be available to a catch block

	// a 2-arg constructor that receives a message and a double value that represents the overdraft amount
	public OverdraftException(String message, double overdraftAmount) {
		super(message);		// call the Exception class constructor (our super c;ass) with the message to display
		this.overdraftAmount = overdraftAmount;		// save the overdraft amount so it is available to any catch block
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}
}
