package com.ibmpod.registrationform.service;

import java.util.List;

import com.ibmpod.registrationform.model.Customer;

public interface CustomerService {
	
	List<Customer> retrieveCustomers();
    //String retrieveCustomerById(Long id);
   // List<String> retrieveCustomerNames();

}
