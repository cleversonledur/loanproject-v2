package br.com.loanproject.loan.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loanproject.commons.exception.BusinessException;
import br.com.loanproject.loan.model.Loan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanServiceTest {

	@Autowired
	private LoanService loanService;
	
	@Test
	public void testCalculateLoanA() throws BusinessException {
		
		Loan loan = loanService.calculateLoan(2000, 10, "A");
		
		assertEquals(2000*0.019*10, loan.getInterest(), 0.0002);
		assertEquals(loan.getMonthlyPayment(), loan.getTotal()/10, 0.0002);
		
	}
	
	@Test
	public void testCalculateLoanB() throws BusinessException {
		
		Loan loan = loanService.calculateLoan(2000, 10, "B");
		
		assertEquals(2000*0.05*10, loan.getInterest(), 0.0002);
		assertEquals(loan.getMonthlyPayment(), loan.getTotal()/10, 0.0002);
	}
	
	@Test
	public void testCalculateLoanC() throws BusinessException {
		
		Loan loan = loanService.calculateLoan(2000, 10, "C");
		
		assertEquals(2000*0.10*10, loan.getInterest(), 0.0002);
		assertEquals(loan.getMonthlyPayment(), loan.getTotal()/10, 0.002);
	}
	
	@Test
	public void testCalculateLoanABigValue() throws BusinessException {
		
		Loan loan = loanService.calculateLoan(9999999, 10, "A");
		
		assertEquals(9999999*0.019*10, loan.getInterest(), 0.0002);
		assertEquals(loan.getMonthlyPayment(), loan.getTotal()/10, 0.002);
		
	}
	
	@Test
	public void testCalculateLoanBBigValue() throws BusinessException {
		
		Loan loan = loanService.calculateLoan(9999999, 10, "B");
		
		assertEquals(9999999*0.05*10, loan.getInterest(), 0.0002);
		assertEquals(loan.getMonthlyPayment(), loan.getTotal()/10, 0.002);
	}
	
	@Test
	public void testCalculateLoanCBigValue() throws BusinessException {
		
		Loan loan = loanService.calculateLoan(9999999, 10, "C");
		
		assertEquals(9999999*0.10*10, loan.getInterest(), 0.0002);
		assertEquals(loan.getMonthlyPayment(), loan.getTotal()/10, 0.0002);
	}
	
	@Test(expected=BusinessException.class)
	public void testCalculateLoanNegativeMonths() throws BusinessException {
		
		loanService.calculateLoan(2000, -10, "C");
	}
	
	@Test(expected=BusinessException.class)
	public void testCalculateLoanNegativePresentValue() throws BusinessException {
		
		loanService.calculateLoan(-2000, 10, "C");
	}
	
	@Test(expected=BusinessException.class)
	public void testCalculateLoanEmptyRiskType() throws BusinessException {
		
		loanService.calculateLoan(2000, 10, "");
	}
	
	@Test(expected=BusinessException.class)
	public void testCalculateLoanNullRiskType() throws BusinessException {
		
		loanService.calculateLoan(2000, 10, null);
	}
	
	@Test(expected=BusinessException.class)
	public void testCalculateLoanInvalidRiskType() throws BusinessException {
		
		loanService.calculateLoan(2000, 10, "Invalid");
	}
}
