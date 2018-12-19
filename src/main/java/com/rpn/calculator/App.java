package com.rpn.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Stack;

/**
 * RPn calc!
 * 
 * @author jyoti.bandi
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DynamicHelper dynamicHelperInstance = DynamicHelper.getInstance();
		String numOrOperand = " ";

		while (!numOrOperand.equals("x")) {
			try {
				dynamicHelperInstance.process(in.readLine());
			} catch (InvalidOperatorException e) {
				System.out.println(e.getLocalizedMessage());
				if (e.getCause() != null) {
					System.out.println("Original Exception: " + e.getCause().getLocalizedMessage());
				}
			} catch (InsufficientParamException e) {
				System.out.println(e.getLocalizedMessage());
				break;
			} catch (ArithmeticException e) {
				System.out.println(e.getLocalizedMessage());
				break;
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				break;
			} finally {
				DecimalFormat fmt = new DecimalFormat("0.##########");
				Stack<Double> stack = dynamicHelperInstance.getStack();
				System.out.print("Stack: ");
				for (Double value : stack) {
					System.out.print(fmt.format(value) + " ");
				}
				System.out.printf("%n");
			}
		}

	}
}
