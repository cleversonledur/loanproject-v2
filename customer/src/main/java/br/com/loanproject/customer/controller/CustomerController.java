package br.com.loanproject.customer.controller;

import java.util.List;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.loanproject.commons.dto.CustomerDto;
import br.com.loanproject.commons.exception.BusinessException;
import br.com.loanproject.commons.exception.DAOException;
import br.com.loanproject.commons.exception.GenericException;
import br.com.loanproject.customer.model.Customer;
import br.com.loanproject.customer.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping(value = "/all/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Customer> getAllCustomers() throws DAOException, BusinessException {
		
		
		List<Customer> customers;
		customers = customerService.list();
		
		return customers;
		
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<?> getCustomer(@PathVariable Long id) {
		
		Customer customer; 
		
		try{
			customer = customerService.get(id);
		}catch(DAOException e) {
			return ResponseEntity.notFound().build();
		}catch(BusinessException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		
		return ResponseEntity.ok().body(customer);
		
	}
	
	@DeleteMapping("/{id}/")
	public @ResponseBody ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		
		Customer customer; 
		
		try{
			customer = customerService.delete(id);
		}catch(DAOException e) {
			return ResponseEntity.notFound().build();
		}catch(BusinessException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping("/")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> addCustomer(@RequestBody CustomerDto c){
		
		
		Customer customer = new Customer();
		
		try{
			customer = customerService.add(c.getName(), c.getIncome(), c.getRiskType(), c.getAddress());
		}catch(DAOException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch(BusinessException  | GenericException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		} 
		
		return ResponseEntity.ok().body(customer);
	}
	
	@PutMapping("/")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> updateCustomer(@RequestBody CustomerDto c){
		
		Customer customer;
		
		try{
			customer = customerService.update(c.getId(), c.getName(), c.getIncome(), c.getRiskType(), c.getAddress());
		}catch(DAOException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch(BusinessException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		
		return ResponseEntity.ok().body(customer);
		}
}
