package com.rpn.calculator;

import java.util.Stack;

public interface CalcProcessing {

	public static final String SEPERATOR = " ";

	
	/**
	 * Method to return number of Operands for the operator
	 * @return number of Operands
	 */
	int getNumOperands();

	/**
	 * Method to return the keyword for the operator to identify the class
	 * Example: + - undo sqrt
	 * @return the operator 
	 */
	String getKeyword();

	/**
	 * Method to return the opposite keyword for the operator
	 * Used while undo operation Example for Addition operation its Subtraction.
	 * 
	 * @return Opposite operator
	 */
	String getOppositKeyword();

	/**
	 * Method to Calculate the instructions. 
	 * 
	 * @param stack - Stack containing the values or operands
	 * @param instructions - Stack containing instructions of each operation
	 * @param position - position of the operand
	 * @param remStatement - unprocessedStatement
	 * @throws InsufficientParamException
	 * @throws InvalidOperatorException
	 */
	void doCalculation(Stack<Double> stack, Stack<Instruction> instructions, int position, String remStatement)
			throws InsufficientParamException, InvalidOperatorException;

	
	/**
	 * Identify if required operands are present for the operator
	 * 
	 * @param stackSize - size of the stack containing operands
	 * @param position - position of the operand
	 * @param remStatement - unprocessedStatement
	 * @return
	 * @throws InsufficientParamException
	 */
	boolean isEnoughOperandsOnStack(int stackSize, int position, String remStatement) throws InsufficientParamException;

}
