package com.callor.hello.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.UserCompDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.UserCompVO;
import com.callor.hello.models.UserSearchDto;
import com.callor.hello.models.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/customer")
public class UserController {

	private final UserDao userDao;
	private final UserCompDao userCompDao;
	
	public UserController(UserDao userDao, UserCompDao userCompDao) {
		this.userDao = userDao;
		this.userCompDao = userCompDao;
	
	}
	
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String List(@ModelAttribute("SEARCH") UserSearchDto userSearchDto, Model model, HttpSession session ) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<UserVO> userList = userDao.selectSearchAll(userSearchDto);
		List<UserVO> company= userDao.selectCompany();
		log.debug(company.toString());
		log.debug(userList.toString());
				
		model.addAttribute("BODY", "USER_LIST");

		model.addAttribute("USER", userList);
		model.addAttribute("COMP", company);
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(@ModelAttribute(name="ADD") UserCompVO userCompVO, UserVO userVO, Model model) {
		List<UserVO> list = userDao.selectAll();
		model.addAttribute("USER", list);
		
		
		model.addAttribute("BODY", "USER_INSERT");
		
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute(name="ADD") UserCompVO userCompVO) {
		
		int insert = userCompDao.insert(userCompVO);
		
		
			
		return "redirect:/customer/";
	}
	
}
