package com.ibmpod.registrationform.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibmpod.registrationform.model.Role;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	@Autowired
	private EntityManager entityManager;
	
	
	public Role findRoleByName(String roleName) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Role> query = currentSession.createQuery("from Role where name=:roleName", Role.class);
		query.setParameter("roleName", roleName);
		Role role = null;
		
		try {
			role = query.getSingleResult();
		} catch (Exception e) {
			role = null;
		}
		
		return role;
	}


}
