package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.util.CalcImpl;
import com.revature.util.Calculator;

public class CalculatorTest {

	private Calculator<Integer> intCalc;
	
	@BeforeClass // runs once before any tests
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass// runs once after all tests finish
	public static void tearDownAfterClass() throws Exception {
	}

	@Before // runs once before each test
	public void setUp() throws Exception {
		
		intCalc = new CalcImpl<Integer>();
		
	}

	@After // runs once after each test
	public void tearDown() throws Exception {
	}

	@Test
	public void addTwoPositiveIntegersTest() {
		assertEquals("3 + 5 should equal 8", new Integer(8), intCalc.add(3,  5));
	}

	
	
	
	
	
}
