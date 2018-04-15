package br.com.loanproject.loan.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.loanproject.commons.exception.BusinessException;
import br.com.loanproject.loan.model.Loan;
import br.com.loanproject.loan.service.LoanService;

@RestController
@RequestMapping("/")
public class LoanController {

	
	@Autowired
	private LoanService loanService;
	
	
	@PostMapping("calculate")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> calculateLoan( @RequestBody LoanRequestDto loanRequestDto ) {
		
		Loan loan;
		
		try {
			loan = loanService.calculateLoan(loanRequestDto.getPresentValue(), loanRequestDto.getMonths(), loanRequestDto.getRiskType());
		} catch (BusinessException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok(loan);
		
	}
	
}