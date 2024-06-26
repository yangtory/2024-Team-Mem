package com.callor.hello.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.NoticeDao;
import com.callor.hello.dao.UserCompDao;
import com.callor.hello.dao.UserMinfoDao;
import com.callor.hello.models.CompanyVO;
import com.callor.hello.models.NoticeSearchDto;
import com.callor.hello.models.UserMinfoVO;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.DashService;
import com.callor.hello.service.TeacherService;
import com.callor.hello.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/main")
public class MainController {

	private final UserService userService;
	private final TeacherService teacherService;
	private final NoticeDao noticeDao;
	private final UserMinfoDao userMinfoDao;
	private final DashService dashService;
	private final ObjectMapper objectMapper;
	private final UserCompDao userCompDao;

	public MainController(
			UserService userService, TeacherService teacherService, NoticeDao noticeDao, UserMinfoDao userMinfoDao,
			DashService dashService, ObjectMapper objectMapper, UserCompDao userCompDao) {
		super();
		this.userService = userService;
		this.teacherService = teacherService;
		this.noticeDao = noticeDao;
		this.userMinfoDao = userMinfoDao;
		this.dashService = dashService;
		this.objectMapper = objectMapper;
		this.userCompDao = userCompDao;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String loginOK(Model model, NoticeSearchDto noticeSearchDto) {
		model.addAttribute("BODY", "LOGINOK");
		String code = teacherService.getLoginCCode();

		// 공지사항리스트
		noticeSearchDto.setN_ccode(code);
		List<NoticeSearchDto> list = noticeDao.selectSearchAll(noticeSearchDto);
		model.addAttribute("NOTICE_LIST", list);

		// 총매출
		Integer total = userMinfoDao.total(code);
		if (total == null) {
			total = 0;
		}
		model.addAttribute("TOTAL", total);

		// 회원수
		String count = userCompDao.count(code);
		model.addAttribute("COUNT", count);

		return "layout";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("BODY", "MAIN_JOIN");
		return "layout";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO, Model model, CompanyVO compVO) {
		userService.createUser(userVO, compVO);

		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("BODY", "MAIN_LOGIN");
		return "layout";
	}
	

	@ResponseBody
	@RequestMapping(value = "/cnamecheck/{cname}", method = RequestMethod.GET)
	public CompanyVO cname_check(@PathVariable("cname") String cname) {
		return userService.cNameCheck(cname);
	}

	@ResponseBody
	@RequestMapping(value = "/idcheck/{id}", method = RequestMethod.GET)
	public UserVO id_check(@PathVariable("id") String id) {
		return userService.findById(id);
	}

	@ResponseBody
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public String total(UserMinfoVO vo, Model model) {
		String ccode = teacherService.getLoginCCode();
		try {
			int total = userMinfoDao.total(ccode);
			return String.valueOf(total);
		} catch (NullPointerException e) {
			log.error("매출액이 없습니다.");
			return "매출액이 없습니다.";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/MonthTotal", method = RequestMethod.GET)
	public String MonthTotal(UserMinfoVO vo) throws JsonProcessingException {

		String ccode = teacherService.getLoginCCode();

		List<Map<String, Object>> monthTotal = dashService.getMonthlyTotal(ccode);

		log.debug("월매출 {}", monthTotal);
		log.debug("매출 {}", String.valueOf(monthTotal));

		return objectMapper.writeValueAsString(monthTotal);

	}

	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(UserMinfoVO vo) throws JsonProcessingException {

		String ccode = teacherService.getLoginCCode();

		List<Integer> monthUser = dashService.getMonthlyUser(ccode);

		log.debug("유저수 {}", String.valueOf(monthUser));

		return objectMapper.writeValueAsString(monthUser);

	}

}
