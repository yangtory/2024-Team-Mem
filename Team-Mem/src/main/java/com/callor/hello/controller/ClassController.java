package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.ClassDao;
import com.callor.hello.dao.TeacherDao;
import com.callor.hello.models.ClassVO;
import com.callor.hello.models.TeacherVO;
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
	private final TeacherDao teacherDao;
	
	public ClassController(ClassDao classDao, TeacherService teacherService, ScheduleService scheduleService,
			TeacherDao teacherDao) {
		super();
		this.classDao = classDao;
		this.teacherService = teacherService;
		this.scheduleService = scheduleService;
		this.teacherDao = teacherDao;
	}

	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String main(Model model, ClassVO vo) {
		
		String code = teacherService.getLoginCCode();
		vo.setC_ccode(code);
		log.debug(code);
		List<ClassVO> list = classDao.selectAll(code);
		

		model.addAttribute("BODY", "CLASS_MAIN");
		model.addAttribute("LIST", list);
		return "layout";
	}
	
	@RequestMapping(value="/detail/{sdate}", method=RequestMethod.GET)
	public String detail(@PathVariable("sdate") String sdate, Model model, ClassVO vo, TeacherVO teacherVO) {
		String code = teacherService.getLoginCCode();
		vo.setC_ccode(code);
		List<ClassVO> list = classDao.findByClass(sdate, code);
		
		List<TeacherVO> teacher = teacherDao.findByName(code); 
		
		model.addAttribute("TEACHER", teacher);
		
		model.addAttribute("LIST", list);
		model.addAttribute("BODY", "CLASS_DETAIL");
		model.addAttribute("SDATE",sdate);
		
		return "layout";
	}
	
	@ResponseBody
	@RequestMapping(value="/get", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String get(ClassVO vo) {
		String code = teacherService.getLoginCCode();
		vo.setC_ccode(code);
		log.debug("GET{}",code);
		List<ClassVO> list = classDao.selectAll(code);
		if(list != null) {
	        // ScheduleVO 객체를 JSON 문자열로 직렬화
	        // JSON 형식: [{"s_seq":1, "s_title":"제목1", "s_content":"내용1", "s_sdate":"2024-04-21", "s_edate":"2024-04-23"}, {...}, ...]
	        StringBuilder jsonBuilder = new StringBuilder("[");
	        for (ClassVO classVO: list) {
	            jsonBuilder.append("{");
	            jsonBuilder.append("\"s_seq\":").append(classVO.getC_seq()).append(",");
	            jsonBuilder.append("\"s_title\":\"").append(classVO.getC_name()).append("\",");
	            jsonBuilder.append("\"s_content\":\"").append(classVO.getC_tcode()).append("\",");
	            jsonBuilder.append("\"s_sdate\":\"").append(classVO.getC_sdate()).append("\",");
	            jsonBuilder.append("\"s_edate\":\"").append(classVO.getC_edate()).append("\"");
	            jsonBuilder.append("},");
	        }
	        // 마지막 쉼표 제거
	        if (list.size() > 0) {
	            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
	        }
	        jsonBuilder.append("]");
	        
	        return jsonBuilder.toString();
	    }
	    return "[]"; // 데이터가 없을 때 빈 JSON 배열 반환
	}
	
	
	@RequestMapping(value="/insert/{sdate}", method=RequestMethod.GET)
	public String insert(@PathVariable("sdate") String sdate, Model model) {
		model.addAttribute("BODY","CLASS_INSERT");
		model.addAttribute("SDATE", sdate);
		String ccode = teacherService.getLoginCCode();
		List<TeacherVO> list = teacherDao.findByName(ccode);
		model.addAttribute("TLIST",list);
		
		return "layout";
	}
	
	@RequestMapping(value="/insert/{sdate}", method=RequestMethod.POST)
	public String insert(@PathVariable("sdate") String sdate, Model model, ClassVO vo, TeacherVO TcVO) {
		String ccode = teacherService.getLoginCCode();
		vo.setC_ccode(ccode);
		
		
		model.addAttribute("CCODE",ccode);
		
		
		
		scheduleService.insertDate(vo);
		
		
		
		return "redirect:/class";
	}
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public String update(@PathVariable("seq")String seq, Model model) {
		ClassVO vo = classDao.findBySeq(seq);
		model.addAttribute("LIST", vo);
		model.addAttribute("BODY", "CLASS_UPDATE");
		return "layout";
		
	}
	
	
}
