package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.UserDao;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/main")
public class MainController {
	
	private final UserService userService;
	public MainController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("BODY", "MAIN_JOIN");
		return "layout";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.createUser(userVO);
		return null;
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		
		model.addAttribute("BODY", "MAIN_LOGIN");
		
		return "layout";
	}


	
}
