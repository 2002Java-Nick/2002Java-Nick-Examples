package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.pojo.Loan;
import com.revature.service.LoanServiceImpl;
import com.revature.util.Calculator;

@RunWith(MockitoJUnitRunner.class)
public class LoanTest {
	
	@Mock
	Calculator<Double> calc;
	
	Loan loan;
	
	LoanServiceImpl loanService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		loanService = new LoanServiceImpl();
		loan = new Loan();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simpleMonthlyCalculatePaymentAmountTest() {
		loan.setInterest(0.04);
		loan.setInterestType(Loan.InterestType.SIMPLE);
		loan.setPeriod(Loan.Period.MONTHLY);
		loan.setPrinciple(2000.0);
		loan.setLength(5);
		when(calc.mult(0.04, 5.0)).thenReturn(0.20);
		when(calc.add(1.0, 0.20)).thenReturn(1.20);
		when(calc.mult(2000.0, 1.20)).thenReturn(2400.0);
		when(calc.mult(5.0, 12.0)).thenReturn(60.0);
		when(calc.div(2400.0, 60.0)).thenReturn(40.0);
		loanService.setCalc(calc);
		assertEquals("Payments for " + loan + " should be equal to 40.0",
				new Double(40.0),
				loanService.calculateMonthlyPaymentAmount(loan));
	}

}



