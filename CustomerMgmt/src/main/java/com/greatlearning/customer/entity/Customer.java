package com.greatlearning.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	public Customer(String firstname, String lastname, String email) {
		super();

		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getfirstname() {
//		return firstname;
//	}
//
//	public void setfirstname(String firstname) {
//		this.firstname = firstname;
//	}
//
//	public String getlastname() {
//		return lastname;
//	}
//
//	public void setlastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//	public String getemail() {
//		return email;
//	}
//
//	public void setemail(String email) {
//		this.email = email;
//	}
//
//	public Customer() {
//
//	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}

}
