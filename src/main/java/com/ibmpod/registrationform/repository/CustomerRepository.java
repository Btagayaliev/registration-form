package com.ibmpod.registrationform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ibmpod.registrationform.model.Customer;

public interface CustomerRepository {

	public Customer findByEmail(String email);
	
	public void save(Customer customer);
	
}
