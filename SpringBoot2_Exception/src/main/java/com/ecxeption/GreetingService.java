package com.ecxeption;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public HelloGoodbye createGreeting(String type, int id) throws Exception {
		HelloGoodbye helloGoodbye = new HelloGoodbye();
		if (type.equals("hello")) {
			helloGoodbye.setGreeting("Hello there." + this.getPersonName(id));
		} else if (type.equals("goodbye")) {
			helloGoodbye.setGreeting("Hello there." + this.getPersonName(id));
		} else {
			throw new GreetingTypeException("Valid types are hello or goodbye. 2222");
		}

		helloGoodbye.setType(type);
		return helloGoodbye;
	}

	public String getPersonName(int id) {
		if (id == 1) {
			return "Tom";
		} else if (id == 2) {
			return "Sue";
		} else {
			throw new NameNotFoundException(Integer.toString(id));
		}
	}
}