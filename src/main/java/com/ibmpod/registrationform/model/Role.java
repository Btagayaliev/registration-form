package com.ibmpod.registrationform.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	private String name;
	@ManyToMany(mappedBy="roles")
	private List<Customer> customers;
	
	public Role(String name, List<Customer> customers) {
		this.name = name;
		this.customers = customers;
	}
	
	public Role() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
