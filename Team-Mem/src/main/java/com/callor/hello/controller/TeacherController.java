package com.callor.hello.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.TeacherDao;
import com.callor.hello.models.TeacherSearchDto;
import com.callor.hello.models.TeacherVO;
import com.callor.hello.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

	private final TeacherDao teacherDao;
	private final TeacherService teacherService;

	public TeacherController(TeacherDao teacherDao, TeacherService teacherService) {
		this.teacherDao = teacherDao;
		this.teacherService = teacherService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(@ModelAttribute("SEARCH") TeacherSearchDto teacherSearch, Model model) {

		String t_ccode = teacherService.getLoginCCode();
		teacherSearch.setT_ccode(t_ccode);
		List<TeacherVO> teacherList = teacherDao.selectSearchAll(teacherSearch);

		model.addAttribute("comp", t_ccode);
		model.addAttribute("SEARCH_LIST", teacherList);
		log.debug("teacherList {} ", teacherList.toString());

		model.addAttribute("SEARCH", teacherSearch);
		model.addAttribute("BODY", "TEACHER_HOME");

		return "layout";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		String tCode = teacherService.createTCode();
		String comp = teacherService.getLoginCCode();
		log.debug("teacher : 사용자의 업체코드{}", comp);

		model.addAttribute("COMP", comp);
		model.addAttribute("TCODE", tCode);
		model.addAttribute("BODY", "TEACHER_INSERT");
		return "layout";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("SEARCH") TeacherVO vo) {
		teacherDao.insert(vo);
		log.debug("insert {} ", vo);
		return "redirect:/teacher/";
	}

	@RequestMapping(value = "/detail/{tcode}", method = RequestMethod.GET)
	public String detail(@PathVariable("tcode") String tcode, Model model) {
		TeacherVO vo = teacherDao.findById(tcode);
		model.addAttribute("LIST", vo);
		model.addAttribute("BODY", "TEACHER_DETAIL");
		return "layout";
	}

	@RequestMapping(value = "/update/{tcode}", method = RequestMethod.GET)
	public String update(@PathVariable("tcode") String tcode, Model model) {
		TeacherVO vo = teacherDao.findById(tcode);
		model.addAttribute("VO", vo);
		model.addAttribute("BODY", "TEACHER_INSERT");
		return "layout";
	}

	@RequestMapping(value = "/update/{tcode}", method = RequestMethod.POST)
	public String update(@PathVariable("tcode") String tcode, TeacherVO vo) {
		teacherDao.update(vo);
		String retString = String.format("redirect:/teacher/detail/{tcode}", vo.getT_code());
		return retString;
	}

	@RequestMapping(value = "/delete/{tcode}", method = RequestMethod.GET)
	public String delete(@PathVariable("tcode") String tcode) {
		teacherDao.delete(tcode);
		return "redirect:/teacher/";
	}

}
