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

import com.organization.empmanagement.entity.Department;
import com.organization.empmanagement.service.DepService;

@RestController
@RequestMapping("/department")
public class DepController {
	@Autowired
	DepService depService;

	@GetMapping
	private ResponseEntity<List<Department>> getAllDepartments() {
		return new ResponseEntity<List<Department>>(depService.getAllDepartments(), HttpStatus.OK);
	}

	@GetMapping("/{depId}")
	private ResponseEntity<Department> getDepById(@PathVariable int depId) {
		return new ResponseEntity<Department>(depService.getDepById(depId), HttpStatus.OK);
	}

	@PostMapping
	private ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		return new ResponseEntity<Department>(depService.saveDepartment(department), HttpStatus.CREATED);
	}

	@PutMapping("/{depId}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Integer depId,
			@RequestBody Department department) {
		return new ResponseEntity<Department>(depService.updateDepartment(depId, department), HttpStatus.OK);
	}

	@DeleteMapping("/{depId}")
	public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable Integer depId) {
		depService.deleteDepartment(depId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
