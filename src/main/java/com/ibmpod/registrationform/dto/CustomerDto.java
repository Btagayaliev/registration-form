package com.ibmpod.registrationform.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {
	
	@NotNull(message = " is required")
	@Valid
	private String email;
	
	@NotNull(message = "is required")
	@Size(min = 6)
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 6)
	private String passwordConfirm;
	
	@NotNull(message = "is required")
	private String firstName;
	
	@NotNull(message = "is required")
	private String lastName;
	
	@NotNull(message = " is required")
	private String dateOfBirth;
	
	public CustomerDto() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
