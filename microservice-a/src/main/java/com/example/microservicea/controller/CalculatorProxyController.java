package com.example.microservicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicea.model.CalculatedResult;
import com.example.microservicea.model.CalculatorBean;
import com.example.microservicea.service.CalculatorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CalculatorProxyController {

	@Autowired
	CalculatorService calculatorService;
	
	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/calculate/{firstParam}/{secondParam}")
	public CalculatedResult Calculate(@PathVariable float firstParam, @PathVariable float secondParam) {
		CalculatorBean res = calculatorService.getResult(firstParam, secondParam);
		CalculatedResult calculatedResult = new CalculatedResult();
		calculatedResult.setResult(res.getResult());
		return calculatedResult;

	}
	
	public CalculatedResult fallback( float firstParam,  float secondParam) {
	    return new CalculatedResult(0);
	}
}
