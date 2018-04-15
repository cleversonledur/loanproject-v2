package br.com.loanproject.customer.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.loanproject.commons.exception.BusinessException;
import br.com.loanproject.commons.exception.DAOException;
import br.com.loanproject.commons.exception.GenericException;
import br.com.loanproject.customer.model.Customer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {


	@Autowired
	private CustomerService service;
	
	@Test
	public void testGet() throws DAOException, BusinessException, GenericException {
		Customer customer = service.add("John Test", 1000, "A", "Street x");
		
		customer = service.get(customer.getId());
		assertNotNull(customer);
	}

	@Test
	public void testAdd() throws DAOException, BusinessException, GenericException {
		Customer customer = service.add("John Test", 1000, "A", "Street x");
		assertNotNull(customer);
	}
	
	@Test(expected=BusinessException.class)
	public void testAddInvalidName() throws DAOException, BusinessException, GenericException {
		Customer customer = service.add(null, 1000, "A", "Street x");
		assertNotNull(customer);
	}
	
	@Test(expected=BusinessException.class)
	public void testAddInvalidIncome() throws DAOException, BusinessException, GenericException {
		Customer customer = service.add("John Test", -1, "A", "Street x");
		assertNotNull(customer);
	}
	
	@Test(expected=GenericException.class)
	public void testAddInvalidRiskType() throws DAOException, BusinessException, GenericException {
		Customer customer = service.add("John Test", 1000, "XXX", "Street x");
		assertNotNull(customer);
	}
	
	@Test(expected=BusinessException.class)
	public void testAddNullRiskType() throws DAOException, BusinessException, GenericException {
		Customer customer = service.add("John Test", 1000, null, "Street x");
		assertNotNull(customer);
	}
	
	@Test(expected=BusinessException.class)
	public void testAddNullAddress() throws DAOException, BusinessException, GenericException {
		Customer customer = service.add("John Test", 1000, "XXX", null);
		assertNotNull(customer);
	}

	@Test(expected=BusinessException.class)
	public void testAddEmptyAddress() throws DAOException, BusinessException, GenericException {
		Customer customer = service.add("John Test", 1000, "XXX", "");
		assertNotNull(customer);
	}
	
	@Test
	public void testUpdate() throws DAOException, BusinessException {
		List<Customer> customers = service.list();
		Customer customer = customers.get(0);
		
		customer.setName("John Updated");
		service.update(customer.getId(), customer.getName(), customer.getIncome(), customer.getRiskType().toString(), customer.getAddress());
	}

	@Test
	public void testDelete() throws DAOException, BusinessException {
		List<Customer> customers = service.list();
		Customer customer = customers.get(0);
		
		service.delete(customer.getId());
		
		List<Customer> customersAfterDeletion = service.list();
		
		for(Customer c : customersAfterDeletion) {
			assertNotEquals(c.getId(), customer.getId());
		}
		
	}

}
