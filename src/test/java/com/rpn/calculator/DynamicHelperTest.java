package com.rpn.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rpn.calculator.DynamicHelper;
import com.rpn.calculator.InsufficientParamException;

public class DynamicHelperTest {
	@Test
    public void testPushOperands() throws Exception {
		DynamicHelper dynamicHelpeInstance = DynamicHelper.getInstance();

		// Push operands
		dynamicHelpeInstance.process("5 2");
        assertEquals(5, dynamicHelpeInstance.getStack().get(0), 0);
        assertEquals(2, dynamicHelpeInstance.getStack().get(1), 0);
        
        dynamicHelpeInstance.process("clear");   
        
        assertEquals(0, dynamicHelpeInstance.getStack().size(), 0);
	}  
	@Test
    public void testSqrt() throws Exception {
		DynamicHelper dynamicHelpeInstance = DynamicHelper.getInstance();

		// Push operands
		dynamicHelpeInstance.process("2 sqrt");
		assertEquals(1, dynamicHelpeInstance.getStack().size(), 0);
        dynamicHelpeInstance.process("clear"); 
        
        dynamicHelpeInstance.process("9 sqrt");        
        assertEquals(3, dynamicHelpeInstance.getStack().get(0), 0);
        dynamicHelpeInstance.process("clear"); 
	}
	
	@Test
    public void testSubtract() throws Exception {
		DynamicHelper dynamicHelpeInstance = DynamicHelper.getInstance();
		
		dynamicHelpeInstance.process("5 2 -");
		assertEquals(3, dynamicHelpeInstance.getStack().get(0), 0);
		dynamicHelpeInstance.process("3 -");
		assertEquals(0, dynamicHelpeInstance.getStack().get(0), 0);
        dynamicHelpeInstance.process("clear");        
        assertEquals(0, dynamicHelpeInstance.getStack().size(), 0);
	}
	
	@Test
    public void testUndo() throws Exception {
		DynamicHelper dynamicHelpeInstance = DynamicHelper.getInstance();
		
		dynamicHelpeInstance.process("5 4 3 2");
		assertEquals(4, dynamicHelpeInstance.getStack().size());
		dynamicHelpeInstance.process("undo undo *");
		assertEquals(20, dynamicHelpeInstance.getStack().get(0), 0);
        dynamicHelpeInstance.process("5 *");        
        assertEquals(100, dynamicHelpeInstance.getStack().get(0), 0);
        dynamicHelpeInstance.process("undo");
        assertEquals(2, dynamicHelpeInstance.getStack().size(), 0);
        dynamicHelpeInstance.process("clear"); 
	}
	
	@Test
    public void testDivision() throws Exception {
		DynamicHelper dynamicHelpeInstance = DynamicHelper.getInstance();
		
		dynamicHelpeInstance.process("7 12 2 /");
		assertEquals(2, dynamicHelpeInstance.getStack().size(), 0);
		dynamicHelpeInstance.process("*");
		assertEquals(42, dynamicHelpeInstance.getStack().get(0), 0);
        dynamicHelpeInstance.process("4 /");        
        assertEquals(10.5, dynamicHelpeInstance.getStack().get(0), 0);
        dynamicHelpeInstance.process("clear");
        assertEquals(0, dynamicHelpeInstance.getStack().size(), 0);
	}
	
	@Test
    public void testMultiplication() throws Exception {
		DynamicHelper dynamicHelpeInstance = DynamicHelper.getInstance();
		
		dynamicHelpeInstance.process("1 2 3 4 5");
		assertEquals(5, dynamicHelpeInstance.getStack().size(), 0);
		dynamicHelpeInstance.process("*");
		assertEquals(4, dynamicHelpeInstance.getStack().size(), 0);
        dynamicHelpeInstance.process("clear 3 4 -");        
        assertEquals(-1, dynamicHelpeInstance.getStack().get(0), 0);
        dynamicHelpeInstance.process("clear");
        assertEquals(0, dynamicHelpeInstance.getStack().size(), 0);
	}
	
	@Test
    public void testMultiplications() throws Exception {
		DynamicHelper dynamicHelpeInstance = DynamicHelper.getInstance();
		
		dynamicHelpeInstance.process("1 2 3 4 5");
		assertEquals(5, dynamicHelpeInstance.getStack().size(), 0);
		dynamicHelpeInstance.process("* * * *");
		assertEquals(1, dynamicHelpeInstance.getStack().size(), 0);
		dynamicHelpeInstance.process("clear");
        assertEquals(0, dynamicHelpeInstance.getStack().size(), 0);
	}
	
	@Test
    public void testInSufficientParams() throws Exception {
		DynamicHelper dynamicHelpeInstance = DynamicHelper.getInstance();
		
		try {
			dynamicHelpeInstance.process("1 2 3 * 5 + * * 6 5");
	   } catch (InsufficientParamException e) {
	       assertTrue( e.getMessage().contains("Operator * (Position 15) Insufficient parameters."));
	   }
	   assertEquals(1, dynamicHelpeInstance.getStack().size(), 0);
	   assertEquals(11, dynamicHelpeInstance.getStack().get(0), 0);
	   dynamicHelpeInstance.process("clear");
       assertEquals(0, dynamicHelpeInstance.getStack().size(), 0);
	}
}
