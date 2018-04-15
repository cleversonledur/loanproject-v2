package br.com.loanproject.loan.model;

import java.math.BigDecimal;

import br.com.loanproject.commons.enumerate.RiskType;

public abstract class Loan {

	private float presentValue;

	private float ratePerMonth;

	private Integer months;

	private RiskType riskType;
	
	private float total;
	
	private float monthlyPayment;
	
	private float interest;

	
	public Loan() {
		super();
	}

	public void calculateLoan() {
		
		this.ratePerMonth = this.getRatePerMonth();
		
		float rate = this.ratePerMonth;
		int months = this.months;
		this.interest = this.presentValue *  rate  * months;
		this.total = this.presentValue + interest;
		this.monthlyPayment = this.total / months;		
	};

	
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(float monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public float getPresentValue() {
		return presentValue;
	}
	
	public void setPresentValue(float presentValue) {
		this.presentValue = presentValue;
	}
	
	public abstract float getRatePerMonth() ;

	public void setRatePerMonth(float ratePerMonth) {
		this.ratePerMonth = ratePerMonth;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public RiskType getRiskType() {
		return riskType;
	}

	public void setRiskType(RiskType riskType) {
		this.riskType = riskType;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

}
