package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.ScheduleDao;
import com.callor.hello.models.ScheduleVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/schedule")
public class ScheduleController {
	
	private final ScheduleDao scheduleDao;
	public ScheduleController(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
	
	@RequestMapping(value= {"/",""}, method = RequestMethod.GET)
	public String main(Model model) {
		
		model.addAttribute("BODY","SCHEDULE_MAIN");
		
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		
		model.addAttribute("BODY","SCHEDULE_INSERT");
		return "layout";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(Model model, ScheduleVO vo,String s_title, String s_content) {
		scheduleDao.insert(vo);
		log.debug("스케줄: {} {}", s_title, s_content);
		
		return "redirect:/schedule";
	}
	
}
