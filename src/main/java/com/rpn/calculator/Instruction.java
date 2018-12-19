package com.rpn.calculator;

public class Instruction {
	String operator;
	Double value;
	int numberOfOperands;

	public Instruction(String operator, Double value, int numberOfOperands) {
		this.operator = operator;
		this.value = value;
		this.numberOfOperands = numberOfOperands;
	}

	public String getReverseInstruction() throws InvalidOperatorException {
		if (numberOfOperands < 1)
			throw new InvalidOperatorException("invalid operator ", operator);

		return (numberOfOperands < 2) ? String.format("%s", operator)
				: String.format("%f %s %f", value, operator, value);
	}
}
