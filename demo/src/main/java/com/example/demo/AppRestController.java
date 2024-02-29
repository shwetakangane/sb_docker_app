package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {
	
	@GetMapping
	public String getMessage() {
		return "WELCOME";
	}

}
