package com.example.kaitaishinsho.login.domain.service.jdbc;

import com.example.kaitaishinsho.login.domain.model.User;
import com.example.kaitaishinsho.login.domain.repository.UserDao;
import com.example.kaitaishinsho.login.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RestServiceJdbcImpl implements RestService {

	@Autowired
	UserDao dao;

	@Override
	public boolean insert(User user) {
		return false;
	}

	@Override
	public User selectOne(String userId) {
		return null;
	}

	@Override
	public List<User> selectMany() {
		return null;
	}

	@Override
	public boolean update(User user) {
		return false;
	}

	@Override
	public boolean delete(String userId) {
		return false;
	}
}
