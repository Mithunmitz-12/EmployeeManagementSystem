package com.organization.empmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userType;
	private String name;
	private String email;
	private String phoneNo;
	private String password;
	
	public LoginRegister() {
		// TODO Auto-generated constructor stub
	}

	public LoginRegister(Long id, String userType, String name, String email, String phoneNo, String password) {
		super();
		this.id = id;
		this.userType = userType;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRegister [id=" + id + ", userType=" + userType + ", name=" + name + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", password=" + password + "]";
	}
	
	
}
