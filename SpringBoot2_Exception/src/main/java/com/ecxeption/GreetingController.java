package com.ecxeption;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

	@Autowired
	protected GreetingService service;

	@GetMapping("/greet")
	public HelloGoodbye getGreeting(@RequestParam("type") String type, @RequestParam("id") int id) throws Exception {
	//	int i = 0;
		//int k = 22 / i;
		HelloGoodbye goodBye = service.createGreeting(type, id);
		return goodBye;
	} 

	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<?> nameNotFoundException(NameNotFoundException ex, WebRequest request) {
		GreetingError errorDetails = new GreetingError();
		errorDetails.setTimestamp(new Date());
		errorDetails.setMessage("This is an overriding of the standard exception: " + ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<?> arithmeticException(ArithmeticException ex, WebRequest request) {
		GreetingError errorDetails = new GreetingError();
		errorDetails.setTimestamp(new Date());
		errorDetails.setMessage("This is an overriding of the standard exception:" + ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}