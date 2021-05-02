package com.example.kaitaishinsho.login.domain.service;

import com.example.kaitaishinsho.login.domain.model.User;

import java.util.List;

public interface RestService {

	public boolean insert(User user);

	public User selectOne(String userId);

	public List<User> selectMany();

	public boolean updateOne(User user);

	public boolean delete(String userId);
}
