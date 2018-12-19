package com.rpn.calculator;

import java.util.Stack;

public class Clear extends BaseCalculator implements CalcProcessing {

	Clear() {
		setKeyword(CLEAR);
		setNumOperands(0);
		setOppositKeyword("");
	}

	public void doCalculation(Stack<Double> stack, Stack<Instruction> instructions, int position, String remStatement) {
		stack.clear();
		instructions.clear();
	}

}
