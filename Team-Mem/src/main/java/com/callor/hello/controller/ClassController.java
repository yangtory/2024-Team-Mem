package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.ClassDao;
import com.callor.hello.models.ClassVO;
import com.callor.hello.service.ScheduleService;
import com.callor.hello.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/class")
public class ClassController {
	
	private final ClassDao classDao;
	private final TeacherService teacherService;
	private final ScheduleService scheduleService;

	public ClassController(ClassDao classDao, TeacherService teacherService, ScheduleService scheduleService) {
		super();
		this.classDao = classDao;
		this.teacherService = teacherService;
		this.scheduleService = scheduleService;
	}

	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String main(Model model) {
		
		String code = teacherService.getLoginCCode();
		List<ClassVO> list = classDao.selectAll(code);
		
		
		model.addAttribute("BODY", "CLASS_MAIN");
		
		return "layout";
	}
	
	@RequestMapping(value="/detail/{sdate}", method=RequestMethod.GET)
	public String detail(@PathVariable("sdate") String sdate, Model model, ClassVO vo) {
		String code = teacherService.getLoginCCode();
		vo.setC_ccode(code);
		log.debug("날짜 : {}",sdate);
		model.addAttribute("BODY", "CLASS_DETAIL");
		model.addAttribute("SDATE",sdate);
		
		return "layout";
	}
	
	@ResponseBody
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String get() {
		String code = teacherService.getLoginCCode();
		
		List<ClassVO> list = classDao.selectAll(code);
		
		return list.toString();
	}
	
	
	@RequestMapping(value="/insert/{sdate}", method=RequestMethod.GET)
	public String insert(@PathVariable("sdate") String sdate, Model model) {
		model.addAttribute("BODY","CLASS_INSERT");
		model.addAttribute("SDATE", sdate);
		
		return "layout";
	}
	
	@RequestMapping(value="/insert/{sdate}", method=RequestMethod.POST)
	public String insert(@PathVariable("sdate") String sdate, Model model, ClassVO vo) {
		String ccode = teacherService.getLoginCCode();
		vo.setC_ccode(ccode);
		model.addAttribute("CCODE",ccode);
		
		
		scheduleService.insertDate(vo);
		
		
		
		return "redirect:/class";
	}
	
}
