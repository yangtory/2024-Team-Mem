package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.dao.ScheduleDao;
import com.callor.hello.models.ScheduleVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/schedule")
public class ScheduleController {
	
	private final ScheduleDao scheduleDao;
	public ScheduleController(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
	
	@RequestMapping(value= {"/",""}, method = RequestMethod.GET)
	public String main(Model model) {
		
		List<ScheduleVO> list = scheduleDao.selectAll();
		
		model.addAttribute("BODY","SCHEDULE_MAIN");
		model.addAttribute("LIST", list);
		log.debug("LIST{}", list);
		
		return "layout";
	}
	
	
	@RequestMapping(value="/insert/{dates}", method=RequestMethod.GET)
	public String insert(@PathVariable("dates") String dates, Model model,String title) {
		
		
		model.addAttribute("BODY","SCHEDULE_INSERT");
		
		
		return "layout";
	}
	@RequestMapping(value="/insert/{dates}", method=RequestMethod.POST)
	public String insert(@PathVariable("dates") String dates, Model model, ScheduleVO vo) {
		scheduleDao.insert(vo);

		
		return "redirect:/schedule";
	}
	
	@ResponseBody
	@RequestMapping(value="/get/{dates}", method=RequestMethod.GET)
	public String get(@PathVariable("dates") String dates) {
		
		ScheduleVO vo = scheduleDao.findBydate(dates);
		if(vo != null) return vo.toString();
		
		return "데이터없음";
	}
	@ResponseBody
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String get() {
	    List<ScheduleVO> vo = scheduleDao.selectAll();
	    if(vo != null) {
	        // ScheduleVO 객체를 JSON 문자열로 직렬화
	        // JSON 형식: [{"s_seq":1, "s_title":"제목1", "s_content":"내용1", "s_sdate":"2024-04-21", "s_edate":"2024-04-23"}, {...}, ...]
	        StringBuilder jsonBuilder = new StringBuilder("[");
	        for (ScheduleVO schedule : vo) {
	            jsonBuilder.append("{");
	            jsonBuilder.append("\"s_seq\":").append(schedule.getS_seq()).append(",");
	            jsonBuilder.append("\"s_title\":\"").append(schedule.getS_title()).append("\",");
	            jsonBuilder.append("\"s_content\":\"").append(schedule.getS_content()).append("\",");
	            jsonBuilder.append("\"s_sdate\":\"").append(schedule.getS_sdate()).append("\",");
	            jsonBuilder.append("\"s_edate\":\"").append(schedule.getS_edate()).append("\"");
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
	
	
}
