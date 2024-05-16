package com.callor.hello.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.callor.hello.dao.UserDao;
import com.callor.hello.service.UserService;
import com.callor.hello.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-mapper.xml")
public class MainControllerTest {
	
	private UserServiceImpl service;
	private UserDao dao;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testId_check() {
		dao.findById("tory");
	}

}
