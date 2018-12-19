package com.rpn.calculator;

public class InsufficientParamException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InsufficientParamException() {
	}

	InsufficientParamException(String reason) {
		super(reason);
	}

	InsufficientParamException(String reason, String statement) {
		super(reason + ":" + statement);
	}

	InsufficientParamException(String reason, String statement, Throwable cause) {
		super(reason + ":" + statement, cause);
	}

}
