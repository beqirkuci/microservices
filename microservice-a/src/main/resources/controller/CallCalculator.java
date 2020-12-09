package com.example.microserviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microserviceb.model.CalculatorBean;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

@RestController
public class Calculator {

	@Autowired
	CalculatorBean calculatorBean;

	private DynamicStringProperty propertyOneWithDynamic = DynamicPropertyFactory.getInstance()
			.getStringProperty("archaius.properties.operator", "not found!");

	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/calculate/{firstParam}/{secondParam}")
	public CalculatorBean Calculate(@PathVariable float firstParam, @PathVariable float secondParam) {

		String operator = propertyOneWithDynamic.get();
		if (operator.trim().contentEquals("+")) {

			calculatorBean.setResult(Float.sum(firstParam, secondParam));
		} else if (operator.trim().contentEquals("-")) {

			calculatorBean.setResult(firstParam - secondParam);
		} else if (operator.trim().contentEquals("*")) {

			calculatorBean.setResult(firstParam * secondParam);
		} else if (operator.trim().contentEquals("/")) {

			calculatorBean.setResult(firstParam / secondParam);

		} else
			calculatorBean.setResult(0);

		return calculatorBean;

	}
}
