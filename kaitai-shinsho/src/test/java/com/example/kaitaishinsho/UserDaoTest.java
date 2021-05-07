package com.example.kaitaishinsho;

import com.example.kaitaishinsho.login.domain.repository.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserDaoTest {

	@Autowired
	UserDao dao;

	@Test
	public void countTest1() {
		assertEquals(dao.count(), 1);
	}

	@Test
	@Sql("/testdata.sql")
	public void countTest2() {
		assertEquals(dao.count(), 2);
	}
}
