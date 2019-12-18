package com.ibmpod.registrationform.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	
	@Id
	@Email
	@NotEmpty
	@Column(unique=true)
	private String email;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String dateOfBirth;
	@NotEmpty
	@Size(min=6)
	private String password;
	private String passwordConfirm;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES", joinColumns= {
			@JoinColumn(name="USER_EMAIL", referencedColumnName="email")
	}, inverseJoinColumns = {@JoinColumn(name="ROLE_NAME", referencedColumnName="name")})
	private List<Role> roles;
	
	
	public Customer(@Email @NotEmpty String email, @NotEmpty String firstName, @NotEmpty String lastName,
			@NotEmpty String dateOfBirth, @NotEmpty @Size(min = 6) String password, String passwordConfirm,
			List<com.ibmpod.registrationform.model.Role> roles) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
	}
	
	public Customer() {
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", password=" + password + ", passwordConfirm=" + passwordConfirm + "]";
	}
	
}
