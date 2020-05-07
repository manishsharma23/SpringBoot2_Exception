package com.ecxeption;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice(assignableTypes  = GreetingController2.class)
@ControllerAdvice
public class GreetingExceptionHandler {
	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<?> nameNotFoundException(NameNotFoundException ex, WebRequest request) {
		GreetingError errorDetails = new GreetingError();
		errorDetails.setTimestamp(new Date());
		errorDetails.setMessage("This a global exception handler name not found: " + ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
/*
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> IdNotFoundException(IdNotFoundException ex, WebRequest request) {
		GreetingError errorDetails = new GreetingError();
		errorDetails.setTimestamp(new Date());
		errorDetails.setMessage("This a global exception handler id not fould: " + ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	*/
	
	
	
}