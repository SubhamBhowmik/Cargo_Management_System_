package com.cargo.exception;

public class CargoNotExistException extends Exception {
	
	public CargoNotExistException(String Message) {
		
		System.out.println(Message);
	}

}
