package com.ibmpod.registrationform.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotEmpty
	@Column(unique=true, name="email")
	private String email;
	
		
	@NotEmpty
	@Column(name="password")
	@Size(min=6)
	private String password;
	
	@NotEmpty
	@Column(name="firstName")
	private String firstName;
	
	@NotEmpty
	@Column(name="lastName")
	private String lastName;
	
	@NotEmpty
	@Column(name="dateOfBirth")
	private String dateOfBirth;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	
	
	public Customer(@NotEmpty String email, @NotEmpty String firstName, @NotEmpty String lastName,
			@NotEmpty String dateOfBirth, @NotEmpty @Size(min = 6) String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}

	public Customer(@Email @NotEmpty String email, @NotEmpty String firstName, @NotEmpty String lastName,
			@NotEmpty String dateOfBirth, @NotEmpty @Size(min = 6) String password, String passwordConfirm,
			List<com.ibmpod.registrationform.model.Role> roles) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.roles = roles;
	}
	
	public Customer() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", email='" + email + '\'' + ", password='" + "********" + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", dateOfBirth='" + dateOfBirth + '\'' + ", roles=" + roles + '}';
	}
	
}
