package com.productapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${hello.massage}")
	private String message;
	

	@GetMapping(path="hello")
	public String sayHello() {
		return message;
	}
}
