package com.rpn.calculator;

import java.util.Stack;

public class Sqrt extends BaseCalculator implements CalcProcessing {

	Sqrt() {
		setKeyword(SQRT);
		setNumOperands(OPERANDS_ONE);
		setOppositKeyword(POW);
	}

	public void doCalculation(Stack<Double> stack, Stack<Instruction> instruction, int position, String remStatement)
			throws InsufficientParamException {
		if (isEnoughOperandsOnStack(stack.size(), position, remStatement)) {
			Double rightVal = stack.pop();
			stack.push(Math.sqrt(rightVal));
			instruction.push(new Instruction(getOppositKeyword(), rightVal, getNumOperands()));
		}
	}

}
