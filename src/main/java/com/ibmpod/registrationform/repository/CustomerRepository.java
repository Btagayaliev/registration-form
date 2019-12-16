package com.ibmpod.registrationform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ibmpod.registrationform.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query("select c.id, c.firstName from Customer c where c.id=:id")
    String findCustomerById(Long id);


}
