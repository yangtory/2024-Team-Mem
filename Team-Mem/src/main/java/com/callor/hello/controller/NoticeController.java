package com.callor.hello.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.NoticeDao;
import com.callor.hello.models.NoticeSearchDto;
import com.callor.hello.models.NoticeVO;
import com.callor.hello.service.TeacherService;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

	private final TeacherService teacherService;
	private final NoticeDao noticeDao;

	public NoticeController(TeacherService teacherService, NoticeDao noticeDao) {
		this.teacherService = teacherService;
		this.noticeDao = noticeDao;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(@ModelAttribute("SEARCH") NoticeSearchDto noticeSearchDto, Model model) {
		String n_ccode = teacherService.getLoginCCode();
		noticeSearchDto.setN_ccode(n_ccode);
		List<NoticeSearchDto> list = noticeDao.selectSearchAll(noticeSearchDto);

		model.addAttribute("SEARCH_LIST", list);
		model.addAttribute("BODY", "NOTICE_HOME");
		return "layout";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("BODY", "NOTICE_INSERT");
		return "layout";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("NOTI") NoticeVO vo, Model model) {
		String id = teacherService.getLoginUid();
		String ccode = teacherService.getLoginCCode();
		vo.setN_ccode(ccode);
		vo.setN_uid(id);
		noticeDao.insert(vo);
		return "redirect:/notice/";
	}

	@ModelAttribute(name = "NOTI")
	private NoticeVO noticeVO() {
		LocalDateTime localDateTime = LocalDateTime.now();

		DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

		NoticeVO vo = NoticeVO.builder().n_date(localDateTime.format(dayFormat))
				.n_time(localDateTime.format(timeFormat)).build();

		return vo;
	}

}
