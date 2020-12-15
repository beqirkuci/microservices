package com.example.microserviceb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatorBean {

	private String operator;

	private float result;

	public CalculatorBean() {
		// Default constructor
	}

	public CalculatorBean(float firsParam, float secondParam, String operator) {

		this.operator = operator;
		if (operator.trim().contentEquals("+")) {
			this.result = Float.sum(firsParam, secondParam);

		} else if (operator.trim().contentEquals("-")) {

			this.result = Float.sum(firsParam, secondParam);
		} else if (operator.trim().contentEquals("*")) {
			this.result = Float.sum(firsParam, secondParam);
		} else if (operator.trim().contentEquals("/")) {
			this.result = Float.sum(firsParam, secondParam);

		} else
		{
			// mock response
			this.result = 0;
		}

	}

}
