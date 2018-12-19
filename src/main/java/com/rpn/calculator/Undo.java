package com.rpn.calculator;

import java.util.Stack;

public class Undo extends BaseCalculator implements CalcProcessing {

	Undo() {
		setKeyword(UNDO);
		setNumOperands(OPERANDS_ONE);
		setOppositKeyword(null);
	}

	public void doCalculation(Stack<Double> stack, Stack<Instruction> instructions, int position, String remStatement)
			throws InsufficientParamException, InvalidOperatorException {

		if (isEnoughOperandsOnStack(stack.size(), position, remStatement)) {

			if (instructions.isEmpty()) {
				stack.pop();
			} else {
				Instruction instruction = instructions.pop();

				if (null == instruction) {
					stack.pop();
				} else {
					String reverseInstruction = instruction.getReverseInstruction();
					DynamicHelper dynamicHelperInstance = DynamicHelper.getInstance();
					dynamicHelperInstance.process(reverseInstruction);
				}
			}
		}
	}
}
