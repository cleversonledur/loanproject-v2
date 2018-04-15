package br.com.loanproject.loan.model;

import br.com.loanproject.commons.enumerate.RiskType;
import br.com.loanproject.commons.exception.BusinessException;

public class LoanFactory {

	private RiskType type;

	public LoanFactory(RiskType type) {
		super();
		this.type = type;
	}
	
	public Loan build() throws BusinessException {
		
		if(this.type.equals(RiskType.A)) {
			return new LoanRiskA();
		}
		
		if(this.type.equals(RiskType.B)) {
			return new LoanRiskB();
		}
		
		if(this.type.equals(RiskType.C)) {
			return new LoanRiskC();
		}
		
		throw new BusinessException("The risk type is invalid");
		
	}
}
