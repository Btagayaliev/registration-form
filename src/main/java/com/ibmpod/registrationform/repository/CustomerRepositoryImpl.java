package com.ibmpod.registrationform.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibmpod.registrationform.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
	private EntityManager entityManager;
	
	@Override
	public Customer findByEmail(String emailAddress) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Customer> query = currentSession.createQuery("from Customer where email=:emailAdd", Customer.class);
		query.setParameter("emailAdd", emailAddress);
		Customer customer = null;
		try {
			customer = query.getSingleResult();
		} catch (Exception e) {
			customer = null;
		}
		
		return customer;
	}

	@Override
	public void save(Customer customer) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
		
	}

}
