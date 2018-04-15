package br.com.loanproject.loan.model;

public class LoanRiskA extends Loan{

	@Override
	public float getRatePerMonth() {
		return (float) 0.019;
	}

}
