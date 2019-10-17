package edu.amrita.medishop.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String password;
	
	@Column(name="phone_number")
	private String phoneNumeber;
	
	private String email;
	
	private Date dob;

	public User() {
		super();
	}

	public User(int id, String name, String password, String phoneNumeber, String email, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phoneNumeber = phoneNumeber;
		this.email = email;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumeber() {
		return phoneNumeber;
	}

	public void setPhoneNumeber(String phoneNumeber) {
		this.phoneNumeber = phoneNumeber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phoneNumeber=" + phoneNumeber
				+ ", email=" + email + ", dob=" + dob + "]";
	}
}
