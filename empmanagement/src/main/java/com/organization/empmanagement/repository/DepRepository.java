package com.organization.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.empmanagement.entity.Department;

public interface DepRepository extends JpaRepository<Department, Integer> {

}
