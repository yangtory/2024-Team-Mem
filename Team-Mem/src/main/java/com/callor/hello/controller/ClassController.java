package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.ClassDao;
import com.callor.hello.dao.ScheduleDao;
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
	private final ScheduleDao scheduleDao;
	


	public ClassController(ClassDao classDao, TeacherService teacherService, ScheduleService scheduleService,
			TeacherDao teacherDao, ScheduleDao scheduleDao) {
		super();
		this.classDao = classDao;
		this.teacherService = teacherService;
		this.scheduleService = scheduleService;
		this.teacherDao = teacherDao;
		this.scheduleDao = scheduleDao;
	}

	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String main(Model model, ClassVO vo) {
		
		String code = teacherService.getLoginCCode();
		vo.setC_ccode(code);
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

		model.addAttribute("LIST", list);
		model.addAttribute("BODY", "CLASS_DETAIL");
		model.addAttribute("SDATE",sdate);
		
		return "layout";
	}
	

	@ResponseBody
	@RequestMapping(value="/get", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String get(ClassVO classvo) {
		String code = teacherService.getLoginCCode();
		classvo.setC_ccode(code);
	    List<ClassVO> vo = classDao.selectAll(code);
	    
	    if(vo != null) {

	        StringBuilder jsonBuilder = new StringBuilder("[");
	        for (ClassVO classVO : vo) {
	            jsonBuilder.append("{");
	            jsonBuilder.append("\"c_seq\":").append(classVO.getC_seq()).append(",");
	            jsonBuilder.append("\"c_name\":\"").append(classVO.getC_name()).append("\",");
	            jsonBuilder.append("\"c_sdate\":\"").append(classVO.getC_sdate()).append("\",");
	            jsonBuilder.append("\"c_edate\":\"").append(classVO.getC_edate()).append("\"");
	            jsonBuilder.append("},");
	        }
	        // 마지막 쉼표 제거
	        if (vo.size() > 0) {
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
		
		List<TeacherVO> list = teacherDao.selectAllComp(ccode);
		List<ClassVO> cList = classDao.selectAll(ccode);
		model.addAttribute("TLIST",list);
		model.addAttribute("CLIST",cList);
		
		return "layout";
	}
	
	@RequestMapping(value="/insert/{sdate}", method=RequestMethod.POST)
	public String insert(@PathVariable("sdate") String sdate, Model model,  ClassVO classVO) {
		String ccode = teacherService.getLoginCCode();
		
		classVO.setC_ccode(ccode);
		scheduleService.insertDate(classVO);
		
		
		return "redirect:/class";
	}
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.GET)
	public String update(@PathVariable("seq")String seq, Model model) {
		ClassVO vo = classDao.findBySeq(seq);
		String code = teacherService.getLoginCCode();
		
		
		model.addAttribute("LIST", vo);
		
		log.debug("UPDATE{}",vo);
		model.addAttribute("BODY", "CLASS_UPDATE");
		return "layout";
		
	}
	
	@RequestMapping(value="/update/{seq}", method=RequestMethod.POST)
	public String update(@PathVariable("seq")String seq, ClassVO vo) {
		log.debug("UPDATE{}",vo);
		String tname = vo.getT_name();
		vo.setT_name(tname);
		classDao.update(vo);
		
		
		
		return "redirect:/class";
	}
	
	
}
