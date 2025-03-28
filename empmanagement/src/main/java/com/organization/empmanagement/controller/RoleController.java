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

import com.organization.empmanagement.entity.Role;
import com.organization.empmanagement.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<List<Role>> getAllRoles() {
		return new ResponseEntity<List<Role>>(roleService.getAllRoles(), HttpStatus.OK);
	}

	@GetMapping("/{roleId}")
	public ResponseEntity<Role> getRoleById(@PathVariable Integer roleId) {
		return new ResponseEntity<Role>(roleService.getRoleById(roleId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		return new ResponseEntity<Role>(roleService.createRole(role), HttpStatus.CREATED);
	}

	@PutMapping("/{roleId}")
	public ResponseEntity<Role> updateRole(@PathVariable Integer roleId, @RequestBody Role role) {
		return new ResponseEntity<Role>(roleService.updateRole(roleId, role), HttpStatus.OK);
	}

	@DeleteMapping("/{roleId}")
	public ResponseEntity<HttpStatus> deleteRole(@PathVariable Integer roleId) {
		roleService.deleteRole(roleId);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
