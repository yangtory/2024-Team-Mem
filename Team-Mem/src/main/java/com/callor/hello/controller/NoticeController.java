package com.callor.hello.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.NoticeDao;
import com.callor.hello.models.Criteria;
import com.callor.hello.models.NoticeSearchDto;
import com.callor.hello.models.NoticeVO;
import com.callor.hello.models.PageMaker;
import com.callor.hello.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String home(@ModelAttribute("SEARCH") NoticeSearchDto noticeSearchDto,
			Model model, Criteria criteria) {
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
	public String insert( NoticeVO vo, Model model) {
		String id = teacherService.getLoginUid();
		String ccode = teacherService.getLoginCCode();
		String nseq = teacherService.createNSeq();
		log.debug("nSeq {}",nseq);
		vo.setN_ccode(ccode);
		vo.setN_uid(id);
		vo.setN_seq(nseq);
		getDateTime(vo);
		noticeDao.insert(vo);
		return "redirect:/notice/";
	}
	
	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model) {
		 NoticeVO vo =noticeDao.findById(seq);
		 model.addAttribute("VO", vo);
		 model.addAttribute("BODY", "NOTICE_DETAIL");
		return "layout";
	}
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, Model model) {
		NoticeVO vo =noticeDao.findById(seq);
		log.debug("VO :{}",vo);
		model.addAttribute("VO", vo);
		model.addAttribute("BODY", "NOTICE_UPDATE");
		return "layout";
	}
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq ,NoticeVO vo, Model model) {
		vo.setN_seq(seq);
		noticeDao.update(vo);
		return "redirect:/notice/";
	}
	@RequestMapping(value="/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq ) {
		noticeDao.delete(seq);
	return "redirect:/notice/";	
	}
	
	private void getDateTime(NoticeVO vo) {
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		vo.setN_date(lt.format(date));
		vo.setN_time(lt.format(time));
		
	}

}
