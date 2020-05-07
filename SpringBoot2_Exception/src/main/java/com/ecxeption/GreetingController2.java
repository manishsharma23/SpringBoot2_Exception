package com.ecxeption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting2")
public class GreetingController2 {

	@Autowired
	protected GreetingService service;

	@GetMapping("/greet2")
	public HelloGoodbye getGreeting(@RequestParam("type") String type, @RequestParam("id") int id) throws Exception {
		HelloGoodbye goodBye = service.createGreeting(type, id);
		return goodBye;
	}
}