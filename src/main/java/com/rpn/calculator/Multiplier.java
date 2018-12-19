package com.rpn.calculator;

import java.util.Stack;

public class Multiplier extends BaseCalculator implements CalcProcessing {

	Multiplier() {
		setKeyword(MULTIPLY);
		setNumOperands(OPERANDS_TWO);
		setOppositKeyword(DIVIDE);
	}

	public void doCalculation(Stack<Double> stack, Stack<Instruction> instruction, int position, String remStatement)
			throws InsufficientParamException {

		if (isEnoughOperandsOnStack(stack.size(), position, remStatement)) {
			Double rightVal = stack.pop();
			Double leftVal = stack.pop();
			stack.push(leftVal * rightVal);
			instruction.push(new Instruction(getOppositKeyword(), rightVal, getNumOperands()));
		}
	}
}
