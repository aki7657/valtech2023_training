package com.valtech.training.spring.aop;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionHandlerAdvice implements ThrowsAdvice{
	
	public void afterThrowing(Exception ex) {
		System.out.println("The exception that has occured is: "+ex.getMessage());
	}

}
