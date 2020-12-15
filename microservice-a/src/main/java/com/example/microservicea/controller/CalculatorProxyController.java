package com.example.microservicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicea.service.CalculatorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CalculatorProxyController {

	@Autowired
	CalculatorService calculatorService;

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/calculate/{firstParam}/{secondParam}")
	public Object Calculate(@PathVariable float firstParam, @PathVariable float secondParam) {

		return calculatorService.getResult(firstParam, secondParam);

	}

	public Object fallback(float firstParam, float secondParam) {
		// mock response
		return 0;
	}
}
