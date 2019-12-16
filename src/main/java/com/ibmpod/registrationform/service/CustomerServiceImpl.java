package com.ibmpod.registrationform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibmpod.registrationform.model.Customer;
import com.ibmpod.registrationform.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> retrieveCustomers() {
		
		//return (List<Customer>) customerRepository.findAll();
		 List<Customer> customers = new ArrayList<Customer>();
	        customerRepository.findAll().forEach(customer -> customers.add(customer));
	        return customers;
	}

	
	  @Override public String retrieveCustomerById(Long id) { 
		  
		  	Optional<String> optional = Optional.ofNullable(customerRepository.findCustomerById(id));
	  		String customer = optional.orElseThrow(CustomerNotFoundException::new);
	  		return customer; 
	  }
	  
	  
	  
	  public void saveOrUpdate(Customer customer) {
	        customerRepository.save(customer);
	    }

}
