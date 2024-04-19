package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/ticket")
public class TicketController {
	
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("BODY","TICKET_HOME");
		return "layout";
	}

}
