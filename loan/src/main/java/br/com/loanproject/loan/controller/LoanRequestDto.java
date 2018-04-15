package br.com.loanproject.loan.controller;

public class LoanRequestDto {
	
	private float presentValue; 
	private int months; 
	private String riskType;
	
	public float getPresentValue() {
		return presentValue;
	}
	public void setPresentValue(float presentValue) {
		this.presentValue = presentValue;
	}
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

}
