package com.callor.hello.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.callor.hello.dao.CompanyDao;
import com.callor.hello.dao.UserCompDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.UserCompSearchDto;
import com.callor.hello.models.UserCompVO;
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
	private final CompanyDao companyDao;


	public UserController(UserDao userDao, UserCompDao userCompDao, UserService userSerivce,
			TeacherService teacherService, CompanyDao companyDao) {
		super();
		this.userDao = userDao;
		this.userCompDao = userCompDao;
		this.userSerivce = userSerivce;
		this.teacherService = teacherService;
		this.companyDao = companyDao;
	}

	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String List(@ModelAttribute("SEARCH") UserCompSearchDto userCompSearchDto, Model model, UserVO vo, UserCompVO userCompVO ) { 
		
		String c_code = teacherService.getLoginCCode();

		userCompSearchDto.setCcode(c_code);
		List<UserCompVO> userList = userCompDao.selectSearchAll(userCompSearchDto);
		model.addAttribute("CCODE", c_code);
		model.addAttribute("BODY", "USER_LIST");
		model.addAttribute("USER", userList);
		
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(UserCompVO userCompVO, UserVO userVO, Model model) {
		// 유저 리스트 
		List<UserVO> list = userDao.selectAll();
		model.addAttribute("USER", list);
		
		String ccode = teacherService.getLoginCCode();
		String cname = companyDao.findCname(ccode);
		
		model.addAttribute("CCODE", ccode);
		model.addAttribute("CNAME", cname);
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
		userSerivce.findById(seq);
		return null;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public UserVO get(@PathVariable("id") String id,Model model,  HttpServletResponse response) {
		UserVO vo = userDao.findById(id);
		return userDao.findById(id);
	}
	
	
	
}
