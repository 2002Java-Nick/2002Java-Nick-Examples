package com.revature.service;

import com.revature.pojo.Loan;

public interface LoanService {
	
	public Double calculateMonthlyPaymentAmount(Loan loan);
	
	public Double makeScheduledPayment(Loan loan);

}
