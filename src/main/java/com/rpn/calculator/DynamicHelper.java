package com.rpn.calculator;

import java.util.Stack;

/**
 * @author jyoti.bandi
 *
 */
public class DynamicHelper {
	private CalcProcessing[] handlers;
	private static Stack<Double> stack = new Stack<Double>();
	private static Stack<Instruction> instructions = new Stack<Instruction>();

	private DynamicHelper(CalcProcessing[] handlers) {
		this.handlers = handlers;
	}

	private static DynamicHelper dynamicHelperInstance;

	/**
	 * Method to return the single instance of the class
	 * @return instance
	 */
	public static synchronized DynamicHelper getInstance() {
		if (dynamicHelperInstance == null) {
			dynamicHelperInstance = new DynamicHelper(new CalcProcessing[] { new Adder(), new Undo(), new Divider(),
					new Sqrt(), new Clear(), new Substractor(), new Multiplier() });
		}
		return dynamicHelperInstance;
	}

	/**
	 * Method to process instructions for RPN calc
	 * 
	 * @param statement - instructions
	 * @throws InvalidOperatorException
	 * @throws InsufficientParamException
	 */
	public void process(String statement) throws InvalidOperatorException, InsufficientParamException {

		String[] parts = statement.trim().split(CalcProcessing.SEPERATOR);
		int position = -1;

		for (String part : parts) {
			position = position + 2;

			if (isOperand(part)) {
				Double number = Double.valueOf(part);
				stack.push(number);
				instructions.push(null);
			} else {
				CalcProcessing theHandler = getHandler(part);
				theHandler.doCalculation(stack, instructions, position, statement.substring(position, statement.length()));
			}
		}
	}
	
	/**
	 * Method to return the handler based on matching operator
	 * 
	 * @param keyword - operator
	 * @return
	 * @throws InvalidOperatorException
	 */
	private CalcProcessing getHandler(String keyword) throws InvalidOperatorException {
		
		for (CalcProcessing handler : handlers) {

			if (keyword.equalsIgnoreCase(handler.getKeyword())) {
				return handler;
			}
		}
		throw new InvalidOperatorException("Invalid Operator: ", keyword);
	}

	/**
	 * Identify if the string is operand or operator
	 * 
	 * @param subString
	 * @return
	 */
	private boolean isOperand(String subString) {
		try {
			Double.valueOf(subString);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public Stack<Double> getStack() {
		return DynamicHelper.stack;
	}

}
