package com.organization.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.empmanagement.entity.LoginRegister;
import com.organization.empmanagement.repository.LoginRegisterRepository;
import com.organization.empmanagement.repository.NotFoundException;

@Service
public class LoginRegisterService {
	@Autowired
	private LoginRegisterRepository repo;

	public LoginRegister saveUser(LoginRegister user) throws Exception {
		String currEmail = user.getEmail();
		LoginRegister userObj = repo.findByEmail(currEmail);
		if (userObj != null) {
			throw new Exception("Email already Exists !!!");
		}
		return repo.save(user);
	}

	public LoginRegister fetchByEmail(LoginRegister user) {
		String currEmail = user.getEmail();
		String currPassword = user.getPassword();
		LoginRegister userObj = repo.findByEmailAndPassword(currEmail, currPassword);
		return user;
	}

	public LoginRegister getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new NotFoundException("User Not Found"));
	}

}
