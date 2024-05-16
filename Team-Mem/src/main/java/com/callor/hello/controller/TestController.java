package com.callor.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
	
	@ResponseBody
	@RequestMapping(value={"/get"}, method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String data() {
		return "하잉";
	}


}
