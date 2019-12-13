package com.ibmpod.registrationform.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibmpod.registrationform.model.Customer;
import com.ibmpod.registrationform.service.CustomerService;

@RestController
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.retrieveCustomers();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	
	  @GetMapping("/{id}/customer") public ResponseEntity<String>
	  getCustomerByID(@PathVariable Long id) { String customer =
	  customerService.retrieveCustomerById(id); return new
	  ResponseEntity<String>(customer, HttpStatus.OK); }
	  
	  public ResponseEntity<List<String>> getCustomerNames() { List<String> names =
	  customerService.retrieveCustomerNames(); return new
	  ResponseEntity<List<String>>(names, HttpStatus.OK); }
	 
}
