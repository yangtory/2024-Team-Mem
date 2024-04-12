package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.TeacherDao;
import com.callor.hello.models.TeacherVO;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
	
	private final TeacherDao teacherDao;
	public TeacherController(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		List<TeacherVO> list = teacherDao.selectAll();
		model.addAttribute("LIST", list);
		model.addAttribute("BODY","TEACHER_HOME");
		return "layout";
	}

}
