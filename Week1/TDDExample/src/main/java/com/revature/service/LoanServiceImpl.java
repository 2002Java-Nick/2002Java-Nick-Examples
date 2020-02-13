package com.revature.service;

import com.revature.pojo.Loan;
import com.revature.util.CalcImpl;
import com.revature.util.Calculator;

public class LoanServiceImpl implements LoanService {

	private Calculator<Double> calc = new CalcImpl<Double>();

	@Override
	public Double calculateMonthlyPaymentAmount(Loan loan) {

		Double paymentAmount = null;

		if (loan.getInterestType() == Loan.InterestType.SIMPLE) {
			double totalInterestPercent = calc.mult(loan.getInterest(), new Double(loan.getLength()));
			double totalWithInterest = calc.mult(loan.getPrinciple(), calc.add(1.0, totalInterestPercent));
			double payments = 0;
			if (loan.getPeriod() == Loan.Period.MONTHLY) {
				payments = calc.mult(new Double(loan.getLength()), 12.0);
			}
			paymentAmount = calc.div(totalWithInterest, payments);
		}
		return paymentAmount;
	}

	@Override
	public Double makeScheduledPayment(Loan loan) {
		return null;
	}

	public void setCalc(Calculator calc) {
		this.calc = calc;
	}

}
