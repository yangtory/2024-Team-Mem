package com.callor.hello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.UserCompDao;
import com.callor.hello.dao.UserMinfoDao;

@Controller
@RequestMapping(value="/test")
public class TestController {

	private final UserMinfoDao userMinfoDao;
	private final UserCompDao userCompDao;
	
	public TestController(UserMinfoDao userMinfoDao, UserCompDao userCompDao) {
		super();
		this.userMinfoDao = userMinfoDao;
		this.userCompDao = userCompDao;
	}





	@ResponseBody
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String test() {
		
	    Integer total = userMinfoDao.total("C0001");
	    String count = userCompDao.count("C0001");
	    if (total == null) {
	        total = 0;
	    }
		return total.toString();
	}
	

}
