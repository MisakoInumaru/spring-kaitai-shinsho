package com.example.kaitaishinsho.login.controller;

import com.example.kaitaishinsho.login.domain.model.User;
import com.example.kaitaishinsho.login.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/rest/insert")
	public String postUserOne(@RequestBody User user) {
		boolean result = service.insert(user);
		String str = "";

		if (result == true) {
			str = "{\"result\":\"ok\"}";
		} else {
			str = "{\"result\":\"error\"}";
		}

		return str;
	}
}
