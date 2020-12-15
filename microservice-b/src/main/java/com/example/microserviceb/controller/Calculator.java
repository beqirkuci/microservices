package com.example.microserviceb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microserviceb.model.CalculatorBean;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

@RestController
public class Calculator {



	private DynamicStringProperty propertyOneWithDynamic = DynamicPropertyFactory.getInstance()
			.getStringProperty("archaius.properties.operator", "not found!");

	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	@RefreshScope
	@GetMapping("/calculate/{firstParam}/{secondParam}")
	public CalculatorBean Calculate(@PathVariable float firstParam, @PathVariable float secondParam) {
		String operator = propertyOneWithDynamic.get();
		CalculatorBean calculatorBean = new CalculatorBean(firstParam,secondParam,operator);
		return calculatorBean;

	}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${message:Hello default}")
	private String message;

	@GetMapping("/message")
	String getMessage() {
		return this.message;
	}
}
}