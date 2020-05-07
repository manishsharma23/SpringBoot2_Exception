package com.ecxeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NameNotFoundException extends RuntimeException {
	public NameNotFoundException(String message) {
		super("The id: " + message + " could not be found.");
	}
}