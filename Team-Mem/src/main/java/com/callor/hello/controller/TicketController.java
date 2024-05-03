package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.MinfoDao;
import com.callor.hello.dao.UserMinfoDao;
import com.callor.hello.models.MinfoVO;
import com.callor.hello.models.UserMinfoVO;
import com.callor.hello.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/ticket")
public class TicketController {
	
	private final MinfoDao minfoDao;
	private final UserMinfoDao userMinfoDao; 
	private final TeacherService teacherService;
	
	public TicketController(MinfoDao minfoDao, UserMinfoDao userMinfoDao, TeacherService teacherService) {
		super();
		this.minfoDao = minfoDao;
		this.userMinfoDao = userMinfoDao;
		this.teacherService = teacherService;
	}

	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public String home(Model model) {
		String cCode =teacherService.getLoginCCode();
		log.debug("로그인 업체 {} ", cCode);
		List<MinfoVO>list = minfoDao.selectAll(cCode);
	
		model.addAttribute("TICKET_LIST", list);
		model.addAttribute("BODY","TICKET_HOME");
		return "layout";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert( Model model) {
		String cCode =teacherService.getLoginCCode();
		model.addAttribute("CCODE",cCode);
		model.addAttribute("BODY", "TICKET_INSERT");
		return "layout";
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(MinfoVO vo) {
		minfoDao.insert(vo);
		return "redirect:/ticket/";
	}
	
	@RequestMapping(value="/detail/{seq}",method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model) {
		MinfoVO vo = minfoDao.findById(seq);
		
		// 이용중 유저
		String ccode = teacherService.getLoginCCode();
		int result = userMinfoDao.countUser(ccode, seq);
		model.addAttribute("COUNT",result);
		model.addAttribute("LIST", vo);
		model.addAttribute("BODY", "TICKET_DETAIL");
		return "layout";
	}
	
	@RequestMapping(value="/update/{seq}",method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, Model model) {
		MinfoVO vo = minfoDao.findById(seq);
		model.addAttribute("L", vo);
		model.addAttribute("BODY", "TICKET_INSERT");
		return "layout";
	}
	
	@RequestMapping(value="/update/{seq}",method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq,MinfoVO vo, Model model) {
		int num = Integer.valueOf(seq); 
		vo.setI_seq(num);
		minfoDao.update(vo);
		String retString = String.format("redirect:/ticket/detail/{seq}", vo.getI_seq());
		return retString;
	}
	
	@RequestMapping(value="/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		minfoDao.delete(seq);
		return "redirect:/ticket/";
	}
	

}
