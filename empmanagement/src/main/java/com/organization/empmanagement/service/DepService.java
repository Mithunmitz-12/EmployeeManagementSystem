package com.organization.empmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.empmanagement.entity.Department;
import com.organization.empmanagement.repository.DepRepository;

@Service
public class DepService {
	@Autowired
	DepRepository depRepo;

	public List<Department> getAllDepartments() {
		return depRepo.findAll();
	}

	public Department getDepById(Integer depId) {
		Optional<Department> department = depRepo.findById(depId);
		return department.orElse(null);
	}

	public Department saveDepartment(Department department) {
		return depRepo.save(department);
	}

	public Department updateDepartment(Integer depId, Department departmentDetails) {
		Optional<Department> department = depRepo.findById(depId);
		if (department.isPresent()) {
			Department existingDepartment = department.get();
			existingDepartment.setName(departmentDetails.getName());
			return depRepo.save(existingDepartment);
		}
		return null;
	}

	public void deleteDepartment(Integer depId) {
		depRepo.deleteById(depId);
	}

}
