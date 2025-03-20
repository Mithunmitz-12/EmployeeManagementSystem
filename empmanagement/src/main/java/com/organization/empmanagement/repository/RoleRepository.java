package com.organization.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.empmanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
