package com.callor.hello.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.CompanyDao;
import com.callor.hello.dao.UserCompDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.dao.UserMinfoDao;
import com.callor.hello.models.UserCompSearchDto;
import com.callor.hello.models.UserCompVO;
import com.callor.hello.models.UserMinfoVO;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.TeacherService;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/customer")
public class UserController {
	
	private final UserDao userDao;
	private final UserCompDao userCompDao;
	private final UserService userSerivce;
	private final TeacherService teacherService;
	private final CompanyDao companyDao;
	private final UserMinfoDao userMinfoDao;


	public UserController(UserDao userDao, UserCompDao userCompDao, UserService userSerivce,
			TeacherService teacherService, CompanyDao companyDao, UserMinfoDao userMinfoDao) {
		super();
		this.userDao = userDao;
		this.userCompDao = userCompDao;
		this.userSerivce = userSerivce;
		this.teacherService = teacherService;
		this.companyDao = companyDao;
		this.userMinfoDao = userMinfoDao;
	}

	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String List(@ModelAttribute("SEARCH") UserCompSearchDto userCompSearchDto, Model model, UserVO vo, UserCompVO userCompVO ) { 
		
		String c_code = teacherService.getLoginCCode();

		userCompSearchDto.setCcode(c_code);
		List<UserCompVO> userList = userCompDao.selectSearchAll(userCompSearchDto);
		model.addAttribute("CCODE", c_code);
		model.addAttribute("BODY", "USER_LIST");
		model.addAttribute("USER", userList);
		
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(UserCompVO userCompVO, UserVO userVO, Model model) {
		// 유저 리스트 
		List<UserVO> list = userDao.selectAll();
		model.addAttribute("USER", list);
		
		String ccode = teacherService.getLoginCCode();
		String cname = companyDao.findCname(ccode);
		String id = teacherService.getLoginUid();
		// 회원권리스트
		List<UserMinfoVO> mInfoList = userMinfoDao.selectAll(ccode);
		model.addAttribute("MINFO", mInfoList);
		
		
		List<UserMinfoVO> mInfoVO = userMinfoDao.findById(id);
		model.addAttribute("UMINFO", mInfoVO);
		
		model.addAttribute("CCODE", ccode);
		model.addAttribute("CNAME", cname);
		model.addAttribute("BODY", "USER_INSERT");
		return "layout";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(UserCompVO userCompVO, UserVO userVO, UserMinfoVO userMinfoVO) {
		if(userMinfoVO.getR_iseq() == 0) {
			userSerivce.codeInput(userVO, userCompVO);			
		}
		if(userMinfoVO.getR_iseq() > 0) {
			userMinfoVO.setR_uid(userVO.getU_id());
			int result = userMinfoDao.insert(userMinfoVO);
			log.debug("insert {}", result);		
		}
		try {
			userSerivce.codeInput(userVO, userCompVO);
		} catch (Exception e) {}
		
		return "redirect:/customer/";
	}
	
	@RequestMapping(value="/detail/{seq}", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model) {
		// USER 정보 
		UserCompVO vo = userCompDao.findById(seq);
		// 한 USER 의 수강권 리스트
		List<UserMinfoVO> list = userMinfoDao.findById(seq);
		log.debug("회원 수강권 정보{} ", list);
		
		model.addAttribute("MINFO", list);
		model.addAttribute("LIST", vo);
		model.addAttribute("BODY", "USER_DETAIL");		
		return "layout";
	}
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, UserCompVO vo, Model model) {
		UserCompVO list = userCompDao.findById(seq);
		String ccode = teacherService.getLoginCCode();
		String cname = companyDao.findCname(ccode);
		
		// 한 user 의 수강권 리스트
		List<UserMinfoVO> mInfoVO = userMinfoDao.findById(seq);
		log.debug("확인{}", mInfoVO);
		// 해당 업체의 수강권 리스트
		List<UserMinfoVO> mInfoList = userMinfoDao.selectAll(ccode);
		
		model.addAttribute("MINFO", mInfoList);
		model.addAttribute("UMINFO", mInfoVO);
		model.addAttribute("CCODE", ccode);
		model.addAttribute("CNAME", cname);
		
		model.addAttribute("BODY", "USER_UPDATE");
		model.addAttribute("COMP",list);
		return "layout";
	}
	
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq, UserCompVO userCompVO,
			 UserMinfoVO userMinfoVO) {
	    userCompDao.update(userCompVO);
	    log.debug("USER UPDATE {}", userCompVO.toString());	    
	    
	    userMinfoVO.setR_uid(seq);
	    userMinfoDao.update(userMinfoVO);
        log.debug("MINFO INSERT {}", userMinfoVO);

	    String retString = String.format("redirect:/customer/detail/{seq}", userCompVO.getUs_uid());        
	    return retString;
	}

	@RequestMapping(value="/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		int result = 0;
		
		try {
			result = userCompDao.delete(seq);
			userMinfoDao.delete(seq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(result > 0) {
			return "redirect:/customer";
		}
		return null;
	}
	
	@RequestMapping(value="/tickinfo/{id}", method=RequestMethod.GET)
	public String tickList(@PathVariable("id") String id,Model model) {
		List<UserMinfoVO> mInfoVO = userMinfoDao.findById(id);
		List<String> dDayList = new ArrayList<>();

		for (UserMinfoVO vo : mInfoVO) {
		    String dDay = getdDay(vo.getR_edate()); // 디데이 계산
		    dDayList.add(dDay); // 디데이 리스트에 추가
		}

		model.addAttribute("DDAY",dDayList);
		model.addAttribute("MINFO",mInfoVO);
		model.addAttribute("BODY", "USER_TICK_INFO");
		return "layout"; 
	}
	
	@RequestMapping(value="/tickdetail/{id}",method=RequestMethod.GET)
	public String tickDetail(Model model) {
		
		model.addAttribute("BODY", "USER_TICK_DETAIL");
		return "layout";
	}
	
	
//	@RequestMapping(value="/insert/{seq}")
//	public String json(@PathVariable("seq") String seq) {
//		userSerivce.findById(seq);
//		return null;
//	}
	
	@ResponseBody
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public UserVO get(@PathVariable("id") String id) {
		UserVO vo =userDao.findById(id);
		return vo;
	}
	
	@ResponseBody
	@RequestMapping(value="/getminfo/{seq}", method=RequestMethod.GET)
	public UserMinfoVO getminfo(@PathVariable("seq") String seq) {
		UserMinfoVO vo = userMinfoDao.findBySeq(seq);
		return vo;
	}
	
	private String getdDay(String edate) {
		LocalDate currentDate = LocalDate.now();		
	    LocalDate endDate = LocalDate.parse(edate); //edate 날짜 변환 
		long dDay = (int) (currentDate.toEpochDay() - endDate.toEpochDay());
		
		return Long.toString(dDay);	
	}
}
