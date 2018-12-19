package com.rpn.calculator;

public class InvalidOperatorException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public InvalidOperatorException() {
	}

	InvalidOperatorException(String reason, String statement) {
		super(reason + ":" + statement);
	}

	InvalidOperatorException(String reason, String statement, Throwable cause) {
		super(reason + ":" + statement, cause);
	}

}
