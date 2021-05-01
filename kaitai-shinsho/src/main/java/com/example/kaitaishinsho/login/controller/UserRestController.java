package com.example.kaitaishinsho.login.controller;

import com.example.kaitaishinsho.login.domain.model.User;
import com.example.kaitaishinsho.login.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

	@Autowired
	RestService service;

	@GetMapping("/rest/get")
	public List<User> getUserMany() {
		return service.selectMany();
	}

	@GetMapping("/rest/get/{id:.+}")
	public User getUserOne(@PathVariable("id") String userId) {
		return service.selectOne(userId);
	}
}
