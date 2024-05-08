package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.UserMinfoDao;
import com.callor.hello.models.SalesSearchDto;
import com.callor.hello.models.TeacherVO;
import com.callor.hello.models.UserMinfoVO;
import com.callor.hello.service.TeacherService;

@Controller
@RequestMapping(value="/sales")
public class SalesController {
	
	private final TeacherService teacherService;
	private final UserMinfoDao userMinfoDao;

	public SalesController(TeacherService teacherService, UserMinfoDao userMinfoDao) {
		super();
		this.teacherService = teacherService;
		this.userMinfoDao = userMinfoDao;
	}


	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(@ModelAttribute("SEARCH")SalesSearchDto salesSearch,Model model) {
		
		String ccode = teacherService.getLoginCCode();
		salesSearch.setS_ccode(ccode);
		List<UserMinfoVO> result = userMinfoDao.salesSearchAll(salesSearch);
		String findCname = userMinfoDao.findCname(ccode);
		
		model.addAttribute("CNAME", findCname);
		model.addAttribute("SALES_LIST", result);
		model.addAttribute("BODY", "SALES_HOME");
		return "layout";
	}
	

}
