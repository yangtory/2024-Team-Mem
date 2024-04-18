package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/schedule")
public class ScheduleController {

	@RequestMapping(value= {"/",""}, method = RequestMethod.GET)
	public String main(Model model) {
		
		model.addAttribute("BODY","SCHEDULE_MAIN");
		
		return "layout";
	}
	
}
