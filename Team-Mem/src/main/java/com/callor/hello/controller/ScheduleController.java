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
import com.callor.hello.service.ScheduleService;
import com.callor.hello.service.impl.ScheduleServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/schedule")
public class ScheduleController {
	
	private final ScheduleDao scheduleDao;
	private final ScheduleService scheduleService;
	
	
	public ScheduleController(ScheduleDao scheduleDao, ScheduleService scheduleService) {
		super();
		this.scheduleDao = scheduleDao;
		this.scheduleService = scheduleService;
	}


	@RequestMapping(value= {"/",""}, method = RequestMethod.GET)
	public String main(Model model, ScheduleVO vo) {
		
//		int result = (vo.getS_seq());
//		
//		String seq = String.valueOf(result);
//		
//		vo.setS_seq(result);

		
		
		List<ScheduleVO>list = scheduleDao.selectAll();
		
		
//		log.debug("{}", result);
		
		
		model.addAttribute("BODY","SCHEDULE_MAIN");
		model.addAttribute("LIST", list);
		log.debug("LIST{}", list.toString());
		
		return "layout";
	}
	
	
	@RequestMapping(value="/insert/{sdate}", method=RequestMethod.GET)
	public String insert(@PathVariable("sdate") String sdate, Model model) {
		model.addAttribute("BODY","SCHEDULE_INSERT");
		model.addAttribute("SDATE", sdate);
		return "layout";
	}
	
	@RequestMapping(value="/insert/{sdate}", method=RequestMethod.POST)
	public String insert(Model model, ScheduleVO vo) {
		
		scheduleService.insertDate(vo);
		log.debug("date {}", vo);
		
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
	@RequestMapping(value="/get", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
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
	
	
	@RequestMapping(value="/detail/{sdate}",method=RequestMethod.GET)
	public String detail(@PathVariable("sdate") String sdate, Model model) {
		
		model.addAttribute("BODY", "SCHEDULE_DETAIL");
		List<ScheduleVO> list = scheduleDao.findByDate(sdate);
		
		model.addAttribute("SDATE", sdate);
		model.addAttribute("LIST", list);
		log.debug("{}", list);
		
		return "layout";
	}
	
	
	
}
