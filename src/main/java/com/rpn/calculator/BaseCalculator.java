package com.rpn.calculator;

public abstract class BaseCalculator implements CalcProcessing {

	public static final String ADD = "+";
	public static final String SUBTRACT = "-";
	public static final String MULTIPLY = "*";
	public static final String DIVIDE = "/";
	public static final String SQRT = "sqrt";
	public static final String UNDO = "undo";
	public static final String CLEAR = "clear";
	public static final String POW = "pow";
	public static final int OPERANDS_TWO = 2;
	public static final int OPERANDS_ONE = 1;

	int numOperands;
	String keyword;
	String oppositKeyword;

	public int getNumOperands() {
		return numOperands;
	}

	public void setNumOperands(int numOperands) {
		this.numOperands = numOperands;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOppositKeyword() {
		return oppositKeyword;
	}

	public void setOppositKeyword(String oppositKeyword) {
		this.oppositKeyword = oppositKeyword;
	}

	public boolean isEnoughOperandsOnStack(int stackSize, int position, String remStatement)
			throws InsufficientParamException {

		if (stackSize < getNumOperands()) {
			StringBuilder builder = new StringBuilder(20);
			builder.append("Operator " + this.getKeyword());
			builder.append(" (Position " + position + ")");
			builder.append(" Insufficient parameters.");
			
			if (null != remStatement && !remStatement.isEmpty()) {
				builder.append("\n(the ");
				builder.append(remStatement);
				builder.append(" were not pushed on to the stack due to the previous error)");
			}
			throw new InsufficientParamException(builder.toString());
		}
		return true;
	}

}
