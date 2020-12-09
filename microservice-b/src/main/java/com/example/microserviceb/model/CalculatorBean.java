package com.example.microserviceb.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
@AllArgsConstructor
public class CalculatorBean {

	private float firsParam;

	private float secondParam;

	private String operator;

	private float result;

	public CalculatorBean() {
		// Default constructor
	}

	public CalculatorBean(String name, float firsParam, float secondParam, String operator, float result) {
		this.firsParam = firsParam;
		this.secondParam = secondParam;
		this.operator = operator;
		this.result = result;
	}

}
