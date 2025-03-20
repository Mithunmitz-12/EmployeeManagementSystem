package com.organization.empmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.empmanagement.entity.Role;
import com.organization.empmanagement.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepo;

	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}

	public Role getRoleById(Integer roleId) {
		Optional<Role> role = roleRepo.findById(roleId);
		return role.orElse(null);
	}

	public Role createRole(Role role) {
		return roleRepo.save(role);
	}

	public Role updateRole(Integer roleId, Role roleDetails) {
		Optional<Role> role = roleRepo.findById(roleId);
		if (role.isPresent()) {
			Role existingRole = role.get();
			existingRole.setName(roleDetails.getName());
			return roleRepo.save(existingRole);
		}
		return null;
	}

	public void deleteRole(Integer roleId) {
		roleRepo.deleteById(roleId);
	}

}
