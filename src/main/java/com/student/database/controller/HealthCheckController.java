package com.student.database.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/health")
public class HealthCheckController {
	@GetMapping
	public String tired() {
		return "hello";
	}
}
