package br.com.loanproject.loan.model;

public class LoanRiskC extends Loan{

	@Override
	public float getRatePerMonth() {
		return (float) 0.10;
	}

}
