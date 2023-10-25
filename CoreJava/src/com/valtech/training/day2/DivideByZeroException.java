package com.valtech.training.day2;

public class DivideByZeroException extends RuntimeException {
//	If using only Exception and not RuntimeException we need to add throws/ try and catch clauses to our program
//	but with only RuntimeException we make it so that the compiler doesn't check for errors until runtime where it'll show an exception has occurred
//	but to handle exception we need the try and catch blocks
	
	public DivideByZeroException(String message) {
		super(message);
	}

}
