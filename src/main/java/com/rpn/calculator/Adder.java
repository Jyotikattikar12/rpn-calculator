package com.rpn.calculator;

import java.util.Stack;

public class Adder extends BaseCalculator implements CalcProcessing {

	Adder() {
		setKeyword(ADD);
		setNumOperands(OPERANDS_TWO);
		setOppositKeyword(SUBTRACT);
	}

	public void doCalculation(Stack<Double> stack, Stack<Instruction> instruction, int position, String remStatement)
			throws InsufficientParamException {

		if (isEnoughOperandsOnStack(stack.size(), position, remStatement)) {
			Double rightVal = stack.pop();
			Double leftVal = stack.pop();
			stack.push(leftVal + rightVal);
			instruction.push(new Instruction(this.getOppositKeyword(), rightVal, this.getNumOperands()));
		}
	}

}
