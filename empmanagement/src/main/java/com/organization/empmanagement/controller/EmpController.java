package com.organization.empmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer empId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(empId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer empId, @RequestBody Employee employee)  {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(empId, employee), HttpStatus.OK);
	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Integer empId) {
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}