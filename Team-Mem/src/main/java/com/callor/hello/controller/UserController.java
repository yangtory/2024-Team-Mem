package com.callor.hello.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.dao.UserCompDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.UserCompVO;
import com.callor.hello.models.UserSearchDto;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/customer")
public class UserController {

	private final UserDao userDao;
	private final UserCompDao userCompDao;
	private final UserService userSerivce;
	public UserController(UserDao userDao, UserCompDao userCompDao, UserService userService) {
		this.userDao = userDao;
		this.userCompDao = userCompDao;
		this.userSerivce = userService;
	}
	
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String List(@ModelAttribute("SEARCH") UserSearchDto userSearchDto, Model model, HttpSession session, Authentication authentication, UserVO vo ) throws AuthenticationException {
		log.debug(session.getAttribute(vo.getU_id())); 
		
		String username = authentication.getName();
		log.debug("로그인된 사용자{}",username);
		
		List<UserVO> userList = userDao.selectSearchAll(userSearchDto);
		List<UserCompVO> company= userCompDao.selectAll();
		log.debug(company.toString());
		log.debug(userList.toString());
				
		model.addAttribute("BODY", "USER_LIST");

		model.addAttribute("USER", userList);
		model.addAttribute("COMP", company);
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(UserCompVO userCompVO, UserVO userVO, Model model) {
		List<UserVO> list = userDao.selectAll();
		model.addAttribute("USER", list);
		
		
		model.addAttribute("BODY", "USER_INSERT");
		
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(UserCompVO userCompVO) {
		

		userSerivce.userInput(userCompVO);
		
		
			
		return "redirect:/customer/";
	}
	
	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model, UserCompVO userCompVO) {
		
		model.addAttribute("BODY", "USER_DETAIL");
		log.debug(seq);
		UserCompVO vo = userCompDao.findById(seq);
		
		model.addAttribute("LIST", vo);
		
		log.debug(vo.toString());
		
		return "layout";
	}
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, UserCompVO vo, Model model) {
		
		model.addAttribute("BODY", "USER_UPDATE");
		return "layout";
	}
	
	
	
}
