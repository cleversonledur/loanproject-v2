package br.com.loanproject.customer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loanproject.commons.enumerate.RiskType;
import br.com.loanproject.commons.exception.BusinessException;
import br.com.loanproject.commons.exception.DAOException;
import br.com.loanproject.commons.exception.GenericException;
import br.com.loanproject.customer.model.Customer;
import br.com.loanproject.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> list() throws DAOException, BusinessException {
		
		Iterable<Customer> customers;
		customers = customerRepository.findAll();
		
		
		List<Customer> customerList = new ArrayList<>();
		customers.forEach(c -> {
			customerList.add(c);
		});
		
		return customerList;
	}
	
	public Customer get(Long id) throws DAOException, BusinessException {
		
		if(id==null) {
			throw new BusinessException("Id is a required information for performing this operation");
		}
		
		Customer customer;
		try {
			customer = customerRepository.findOne(id);
		}catch(Exception e) {
			throw new DAOException(e);
		}
		return customer;
	}

	public Customer add(String name, float income, String riskType, String address) throws DAOException, BusinessException, GenericException {
		
		if(name == null || name.isEmpty()) {
			throw new BusinessException("Name is a required information for performing this operation");
		}
		
		if(income == 0) {
			throw new BusinessException("Income is a required information for performing this operation");
		}
		
		if(riskType == null || riskType.isEmpty()) {
			throw new BusinessException("RiskType is a required information for performing this operation");
		}
		
		if(address == null || address.isEmpty()) {
			throw new BusinessException("Address is a required information for performing this operation");
		}
		
		if (income < 0)	{
			throw new BusinessException("Income must be a positive value.");

		}
	
		Customer customer = new Customer();
		
		customer.setName(name);
		customer.setIncome(income);
		try {
			customer.setRiskType(RiskType.valueOf(riskType));
		
		}catch(Exception e) {
			throw new GenericException(e);
		}
			customer.setAddress(address);
		
		try{
			customerRepository.save(customer);
		}catch(Exception e) {
			throw new DAOException(e);
		}
		
		return customer;
	}
	
public Customer update(Long id, String name, float income, String riskType, String address) throws DAOException, BusinessException {
		
		if(name == null || name.isEmpty()) {
			throw new BusinessException("Name is a required information for performing this operation");
		}
		
		if(income == 0) {
			throw new BusinessException("Income is a required information for performing this operation");
		}
		
		if(riskType == null || riskType.isEmpty()) {
			throw new BusinessException("RiskType is a required information for performing this operation");
		}
		
		if(address == null || address.isEmpty()) {
			throw new BusinessException("Address is a required information for performing this operation");
		}
		
		
		Customer customer = customerRepository.findOne(id);
		
		if(customer == null) {
			throw new BusinessException("Customer does not exists");
		}
		
		try {
			
			customer.setName(name);
			customer.setIncome(income);
			customer.setRiskType(RiskType.valueOf(riskType));
			customer.setAddress(address);
		
			customerRepository.save(customer);

		}catch(Exception e) {
			throw new DAOException(e);
		}
		
		return customer;
	}

	public Customer delete(Long id) throws DAOException, BusinessException {

		if(id==null) {
			throw new BusinessException("Id is a required information for performing this operation");
		}

		try {
			customerRepository.delete(id);
		}catch(Exception e){
			throw new DAOException(e);
		}
		return null;
	}

}
