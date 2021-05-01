package com.example.kaitaishinsho.login.controller;

import com.example.kaitaishinsho.login.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@Autowired
	RestService restService;


}
