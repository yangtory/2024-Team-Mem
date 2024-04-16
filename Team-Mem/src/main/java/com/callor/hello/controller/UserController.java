package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.UserDao;
import com.callor.hello.models.UserSearchDto;
import com.callor.hello.models.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/customer")
public class UserController {

	private final UserDao userDao;
	
	public UserController(UserDao userDao) {
		this.userDao = userDao;
	
	}
	
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String List(@ModelAttribute("SEARCH") UserSearchDto userSearchDto, Model model) {
		
		
		
		List<UserVO> userList = userDao.selectSearchAll(userSearchDto);
		List<UserVO> company= userDao.selectCompany();
		log.debug(company.toString());
		log.debug(userList.toString());
		
		
		
				
		model.addAttribute("BODY", "USER_LIST");

		model.addAttribute("USER", userList);
		model.addAttribute("COMP", company);
		return "layout";
	}
	
	@RequestMapping
	public String insert() {
		return null;
	}
	
}
