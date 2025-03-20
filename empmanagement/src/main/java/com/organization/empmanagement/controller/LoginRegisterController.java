package com.organization.empmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.empmanagement.entity.LoginRegister;
import com.organization.empmanagement.repository.LoginRegisterRepository;
import com.organization.empmanagement.repository.NotFoundException;
import com.organization.empmanagement.service.LoginRegisterService;

@RestController
public class LoginRegisterController {
	@Autowired
	LoginRegisterService service;

	@Autowired
	LoginRegisterRepository repo;

	@PostMapping("/register")
	public ResponseEntity<LoginRegister> register(@RequestBody LoginRegister user) throws Exception {
		try {
			LoginRegister userObj = null;
			userObj = service.saveUser(user);
			return new ResponseEntity<LoginRegister>(userObj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/login")
	public ResponseEntity<LoginRegister> login(@RequestParam LoginRegister user) throws Exception {
		LoginRegister userobj = null;
		userobj = service.fetchByEmail(user);
		if (userobj == null) {
			return new ResponseEntity("User Not Found", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<LoginRegister>(userobj, HttpStatus.OK);
	}

	@GetMapping("/getallusers")
	public List<LoginRegister> getAllUsers() {
		return repo.findAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<LoginRegister> getUser(@PathVariable Long id) {
		LoginRegister user = service.getById(id);
		return new ResponseEntity<LoginRegister>(user, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id) {
		LoginRegister user = repo.findById(id)
				.orElseThrow(() -> new NotFoundException("User doesnt Exist with id" + id));
		repo.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/totaluser")
	public ResponseEntity<List<Integer>> getTotal() throws Exception {
		List<LoginRegister> users = repo.findAll();
		List<Integer> count = new ArrayList<>();
		count.add(users.size());
		return new ResponseEntity<List<Integer>>(count, HttpStatus.OK);
	}

}
