package com.now.exceptions;

public class InvalidMobileNumberException extends RuntimeException {
	public InvalidMobileNumberException(String string) {
	}

	private static final long serialVersionUID = -6144182182693365594L;
	
	//these is the structure of the exceptions I have written here for initial validations, 
	//later it should be re-factored and modified as per new spring-boot standards.

}
