package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddCust {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerid;
	private Long contactno;
	private String fname;
	private String lname;
	private String email;
	private String password;
	public AddCust() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddCust(Long contactno, String fname, String lname, String email, String password) {
		super();
		this.contactno = contactno;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}
	public Long getContactno() {
		return contactno;
	}
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	@Override
	public String toString() {
		return "AddCust [contactno=" + contactno + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
