package br.com.loanproject.loan.model;

public class LoanRiskB extends Loan{

	@Override
	public float getRatePerMonth() {
		return (float) 0.05;
	}

}
