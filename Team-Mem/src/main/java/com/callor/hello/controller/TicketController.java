package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.MinfoDao;
import com.callor.hello.models.MinfoVO;
import com.callor.hello.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/ticket")
public class TicketController {
	
	private final MinfoDao minfoDao;
	private final TeacherService teacherService;
	public TicketController(MinfoDao minfoDao, TeacherService teacherService) {
		this.minfoDao = minfoDao;
		this.teacherService = teacherService;
	}
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public String home(Model model) {
		String cCode =teacherService.getLoginCCode();
		log.debug("로그인 업체 {} ", cCode);
		List<MinfoVO>list = minfoDao.selectAll(cCode);
	
		model.addAttribute("TICKET_LIST", list);
		model.addAttribute("BODY","TICKET_HOME");
		return "layout";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert( Model model) {
		String cCode =teacherService.getLoginCCode();
		model.addAttribute("CCODE",cCode);
		model.addAttribute("BODY", "TICKET_INSERT");
		return "layout";
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(MinfoVO vo) {
		minfoDao.insert(vo);
		return "redirect:/ticket/";
	}
	

}
