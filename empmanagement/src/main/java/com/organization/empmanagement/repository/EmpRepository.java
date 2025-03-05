package com.organization.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.empmanagement.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
