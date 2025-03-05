package com.organization.empmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String name;
	private String phoneNo;
	private String address;
	private LocalDate dob;
	private Double salary;
	private LocalDate doj;
	private String location;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empId, String name, String phoneNo, String address, LocalDate dob, Double salary,
			LocalDate doj, String location) {
		super();
		this.empId = empId;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.dob = dob;
		this.salary = salary;
		this.doj = doj;
		this.location = location;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", dob=" + dob + ", salary=" + salary + ", doj=" + doj + ", location=" + location + "]";
	}
}
