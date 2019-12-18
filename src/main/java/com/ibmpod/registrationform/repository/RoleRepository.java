package com.ibmpod.registrationform.repository;

import com.ibmpod.registrationform.model.Role;

public interface RoleRepository {

	public Role findRoleByName(String roleName);
	
}
