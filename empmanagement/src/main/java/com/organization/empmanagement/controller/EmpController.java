package com.organization.empmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.empmanagement.entity.Employee;
import com.organization.empmanagement.service.EmpService;

@RestController
@RequestMapping("/employees")
public class EmpController {

	@Autowired
	private EmpService employeeService;

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{empId}")
	public Employee getEmployeeById(@PathVariable Integer empId) {
		return employeeService.getEmployeeById(empId);
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/{empId}")
	public Employee updateEmployee(@PathVariable Integer empId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(empId, employee);
	}

	@DeleteMapping("/{empId}")
	public void deleteEmployee(@PathVariable Integer empId) {
		employeeService.deleteEmployee(empId);
	}
}