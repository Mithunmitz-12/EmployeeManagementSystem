package com.organization.empmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.empmanagement.entity.Employee;
import com.organization.empmanagement.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Integer empId) {
		Optional<Employee> employee = employeeRepository.findById(empId);
		return employee.orElse(null);
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Integer empId, Employee employeeDetails) {
		Optional<Employee> employee = employeeRepository.findById(empId);
		if (employee.isPresent()) {
			Employee existingEmployee = employee.get();
			existingEmployee.setName(employeeDetails.getName());
			existingEmployee.setPhoneNo(employeeDetails.getPhoneNo());
			existingEmployee.setAddress(employeeDetails.getAddress());
			existingEmployee.setDob(employeeDetails.getDob());
			existingEmployee.setSalary(employeeDetails.getSalary());
			existingEmployee.setDoj(employeeDetails.getDoj());
			existingEmployee.setLocation(employeeDetails.getLocation());
			return employeeRepository.save(existingEmployee);
		}
		return null;
	}

	public void deleteEmployee(Integer empId) {
		employeeRepository.deleteById(empId);
	}
}