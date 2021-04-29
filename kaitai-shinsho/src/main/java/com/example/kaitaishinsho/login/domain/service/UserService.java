package com.example.kaitaishinsho.login.domain.service;

import com.example.kaitaishinsho.login.domain.model.User;
import com.example.kaitaishinsho.login.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public boolean insert(User user) {

		int rowNumber = dao.insertOne(user);

		boolean result = false;

		if (rowNumber > 0) {
			result = true;
		}
		return result;
	}
}