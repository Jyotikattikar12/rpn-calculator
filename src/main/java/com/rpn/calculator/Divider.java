package com.rpn.calculator;

import java.util.Stack;

public class Divider extends BaseCalculator implements CalcProcessing {

	Divider() {
		setKeyword(DIVIDE);
		setNumOperands(OPERANDS_TWO);
		setOppositKeyword(MULTIPLY);
	}

	public void doCalculation(Stack<Double> stack, Stack<Instruction> instruction, int position, String remStatement)
			throws InsufficientParamException {

		if (isEnoughOperandsOnStack(stack.size(), position, remStatement)) {

			Double rightVal = stack.pop();
			Double leftVal = stack.pop();

			if (rightVal == 0.0) {
				throw new ArithmeticException("Cannot divide by zero!");
			}
			stack.push(leftVal / rightVal);
			instruction.push(new Instruction(this.getOppositKeyword(), rightVal, getNumOperands()));
		}
	}

}
