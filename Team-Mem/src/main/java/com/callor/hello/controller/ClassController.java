package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/class")
public class ClassController {

	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String main(Model model) {
		
		model.addAttribute("BODY", "CLASS_MAIN");
		
		return "layout";
	}
	
	@RequestMapping(value="/detail/{dates}", method=RequestMethod.GET)
	public String detail(@PathVariable("dates") String dates, Model model) {
		
		model.addAttribute("BODY", "CLASS_DETAIL");
		
		return "layout";
	}
}
