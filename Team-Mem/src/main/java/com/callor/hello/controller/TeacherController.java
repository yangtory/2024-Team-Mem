package com.callor.hello.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.dao.TeacherDao;
import com.callor.hello.models.CompanyVO;
import com.callor.hello.models.TeacherSearchDto;
import com.callor.hello.models.TeacherVO;
import com.callor.hello.models.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
	
	private final TeacherDao teacherDao;
	
	public TeacherController(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(@ModelAttribute("SEARCH") TeacherSearchDto teacherSearch, Model model) {
		List<TeacherVO> teacherList = teacherDao.selectSearchAll(teacherSearch);
        
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserVO) {
            UserVO userDetails = (UserVO) authentication.getPrincipal();
            // UserDetails를 통해 추가 정보에 접근할 수 있습니다.
            String ucomp = userDetails.getU_comp();
            log.debug("사용자의 업체명 {}",ucomp);
            String comp = teacherDao.findByComp(ucomp);
            log.debug("사용자의 업체코드{}",comp);
            model.addAttribute("COMP",comp);
        }
        
		model.addAttribute("BODY","TEACHER_HOME");
		model.addAttribute("LIST", teacherList);
		model.addAttribute("SEARCH",teacherSearch);
		
		return "layout";
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.POST)
	public String insert(TeacherVO vo, Model model) {
		int result = teacherDao.insert(vo);
		return "layout";
	}

	

}
