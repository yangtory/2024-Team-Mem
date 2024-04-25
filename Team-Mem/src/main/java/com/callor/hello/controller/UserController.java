package com.callor.hello.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.UserCompDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.UserCompVO;
import com.callor.hello.models.UserSearchDto;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.TeacherService;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/customer")
public class UserController {
	
	private final UserDao userDao;
	private final UserCompDao userCompDao;
	private final UserService userSerivce;
	private final TeacherService teacherService;


	public UserController(UserDao userDao, UserCompDao userCompDao, UserService userSerivce,
			TeacherService teacherService) {
		super();
		this.userDao = userDao;
		this.userCompDao = userCompDao;
		this.userSerivce = userSerivce;
		this.teacherService = teacherService;
	}

	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String List(@ModelAttribute("SEARCH") UserSearchDto userSearchDto, Model model, UserVO vo, UserCompVO userCompVO ) { 
				
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication.getPrincipal() instanceof UserVO) {
//			UserVO detail = (UserVO) authentication.getPrincipal();
//			
//			String cname = detail.getU_comp();
//			log.debug("사용자의 업체명 {}", cname);
//			String ccode = userCompDao.findByCcode(cname);
//			log.debug("사용자의 업체코드{}", ccode);
//			model.addAttribute("CCODE", ccode);
//		}
		
		String c_code = teacherService.getLoginCCode();

//		List<UserCompVO> company= userCompDao.selectAll(c_code);
//		model.addAttribute("COMP", company);
		userSearchDto.setCcode(c_code);
		List<UserVO> userList = userDao.selectSearchAll(userSearchDto);
				
		model.addAttribute("BODY", "USER_LIST");

		model.addAttribute("USER", userList);
		
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
	public String insert(UserCompVO userCompVO, UserVO userVO) {
		userSerivce.codeInput(userVO, userCompVO);
			
		return "redirect:/customer/";
	}
	
	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model, UserCompVO userCompVO) {
		
		model.addAttribute("BODY", "USER_DETAIL");
		log.debug(seq);
		UserCompVO vo = userCompDao.findById(seq);
		
		model.addAttribute("LIST", vo);
		
		
		
		return "layout";
	}
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, UserCompVO vo, Model model) {
		
		UserCompVO list = userCompDao.findById(seq);
		
		
		model.addAttribute("BODY", "USER_UPDATE");
		model.addAttribute("COMP",list);
		return "layout";
	}
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq, UserCompVO vo) {
		
		log.debug("UPDATE {}", vo.toString());
		int result = userCompDao.update(vo);
		String retString = String.format("redirect:/customer/detail/{seq}", vo.getUs_uid());
		
		return retString;
//		return "redirect:/customer/detail/" + vo.getUs_uid();
	}
	
	@RequestMapping(value="/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		
		int result = 0;
		
		try {
			result = userCompDao.delete(seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(result > 0) {
			return "redirect:/customer";
		}
		
		
		
		return null;
	}
	
	@RequestMapping(value="/insert/{seq}")
	public String json(@PathVariable("seq") String seq) {
		
		UserVO userVO = userSerivce.findById(seq);
		
		return null;
	}
	
	
	
	
}
