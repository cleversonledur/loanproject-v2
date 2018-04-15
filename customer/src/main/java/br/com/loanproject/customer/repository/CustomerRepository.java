package br.com.loanproject.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.loanproject.customer.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{

}
