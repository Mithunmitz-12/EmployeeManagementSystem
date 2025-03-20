package com.organization.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.empmanagement.entity.LoginRegister;

public interface LoginRegisterRepository extends JpaRepository<LoginRegister, Long> {
	LoginRegister findByEmail(String currentMail);
    LoginRegister findByEmailAndPassword(String currmail, String currpassword);
}
