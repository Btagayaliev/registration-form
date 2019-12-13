package com.ibmpod.registrationform.service;

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
		
		return (List<Customer>) customerRepository.findAll();
	}

	/*
	 * @Override public String retrieveCustomerById(Long id) { Optional<String>
	 * optionalBreed = Optional.ofNullable(customerRepository.findCustomerById(id));
	 * String customer = optionalBreed.orElseThrow(CustomerNotFoundException::new);
	 * return customer; }
	 * 
	 * @Override public List<String> retrieveCustomerNames() {
	 * 
	 * return (List<String>) customerRepository.findAllNames(); }
	 */
	

}
