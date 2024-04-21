package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.NoticeDao;
import com.callor.hello.models.NoticeSearchDto;
import com.callor.hello.service.TeacherService;

@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
	private final TeacherService teacherService;
	private final NoticeDao noticeDao;
	public NoticeController(TeacherService teacherService, NoticeDao noticeDao) {
		this.teacherService = teacherService;
		this.noticeDao = noticeDao;
	}
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String home(@ModelAttribute("SEARCH") NoticeSearchDto noticeSearchDto, Model model) {
		String ccode = teacherService.getLoginCCode();
		noticeSearchDto.setCcode(ccode);
		List<NoticeSearchDto> list = noticeDao.selectSearchAll(noticeSearchDto);
		
		model.addAttribute("SEARCH_LIST", list);
		model.addAttribute("BODY", "NOTICE_HOME");
		return "layout";
	}

}
