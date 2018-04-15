package br.com.loanproject.loan.service;

import org.springframework.stereotype.Service;

import br.com.loanproject.commons.enumerate.RiskType;
import br.com.loanproject.commons.exception.BusinessException;
import br.com.loanproject.loan.model.Loan;
import br.com.loanproject.loan.model.LoanFactory;

@Service
public class LoanService {

	public Loan calculateLoan(float presentValue, int months, String riskType) throws BusinessException {
		
		if(presentValue == 0) {
			throw new BusinessException("The present value must be informed and cannot be zero.");
		}
		
		if(months == 0) {
			throw new BusinessException("The months value must be informed and cannot be zero.");
		}
		
		if(riskType == null || riskType.isEmpty()) {
			throw new BusinessException("The risk type value must be informed");
		}
		
		if(presentValue < 0) {
			throw new BusinessException("The present value must be positive.");
		}
		
		if(months < 0) {
			throw new BusinessException("The months value must be positive.");
		}
		
		RiskType riskTypeValue;
		
		try {
			riskTypeValue = RiskType.valueOf(riskType);
		}catch(Exception e) {
			throw new BusinessException("The risk type is invalid.");

		}
		Loan loan = new LoanFactory(riskTypeValue).build();
		loan.setMonths(months);
		loan.setPresentValue(presentValue);
		loan.setRiskType(riskTypeValue);
		loan.calculateLoan();
		
		return loan;
		
	}

}
