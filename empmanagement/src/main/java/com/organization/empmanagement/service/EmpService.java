package com.organization.empmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.empmanagement.entity.Department;
import com.organization.empmanagement.entity.Employee;
import com.organization.empmanagement.entity.Role;
import com.organization.empmanagement.repository.DepRepository;
import com.organization.empmanagement.repository.EmpRepository;
import com.organization.empmanagement.repository.NotFoundException;
import com.organization.empmanagement.repository.RoleRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository employeeRepository;
	
	@Autowired
	private DepRepository depRepo;
	
	@Autowired
	private RoleRepository roleRepo;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Integer empId) {
		Optional<Employee> employee = employeeRepository.findById(empId);
		return employee.orElse(null);
	}

	public Employee createEmployee(Employee employee){
		Optional<Department> department= depRepo.findById(employee.getDepartment().getId());
		Optional<Role> role= roleRepo.findById(employee.getRole().getId());
		employee.setDepartment(department.get());
		employee.setRole(role.get());
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
			if(employeeDetails.getDepartment() != null) {
				Optional<Department> department= depRepo.findById(employeeDetails.getDepartment().getId());
				existingEmployee.setDepartment(employeeDetails.getDepartment());
			}
			if(employeeDetails.getRole() != null) {
				Optional<Role> role= roleRepo.findById(employeeDetails.getRole().getId());
				existingEmployee.setRole(employeeDetails.getRole());
			}
			return employeeRepository.save(existingEmployee);
		}
		throw new NotFoundException("Employee Not Found to Update !!!");
	}

	public void deleteEmployee(Integer empId) {
		employeeRepository.deleteById(empId);
	}
}