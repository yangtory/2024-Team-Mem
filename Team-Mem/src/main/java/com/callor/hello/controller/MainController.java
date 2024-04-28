package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.UserDao;
import com.callor.hello.models.CompanyVO;
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
		return "main/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.createUser(userVO);
		return "home";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BODY", "MAIN_LOGIN");
		return "main/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/cnamecheck/{cname}", method=RequestMethod.GET)
	public CompanyVO cname_check(@PathVariable("cname") String cname) {
		return userService.cNameCheck(cname);
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck/{id}",method=RequestMethod.GET)
	public UserVO id_check(@PathVariable("id") String id) {
	return userService.findById(id);
	}


	
}
