package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.callor.hello.dao.ScheduleDao;
import com.callor.hello.models.ScheduleVO;
import com.callor.hello.service.ScheduleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {

	private final ScheduleDao scheduleDao;
	
	
	public ScheduleServiceImpl(ScheduleDao scheduleDao) {
		super();
		this.scheduleDao = scheduleDao;
	}


	@Override
	public int insertDate(ScheduleVO vo) {
		String s_title = vo.getS_title();
		String s_content = vo.getS_content();
		String s_sdate = vo.getS_sdate();
		String s_edate = vo.getS_edate();
		List<ScheduleVO> list = new ArrayList<>();
		if(s_edate.isEmpty()) {
			list.add(vo.builder()
					.s_title(s_title)
					.s_content(s_content)
					
					.s_edate(s_sdate).build());
			vo.setS_edate(s_sdate);
			scheduleDao.insert(vo);
			log.debug(s_edate);
		} else {
			list.add(vo.builder()
					.s_title(s_title)
					.s_content(s_content)
					.s_sdate(s_sdate)
					.s_edate(s_edate).build());
		
			scheduleDao.insert(vo);
			log.debug(s_edate);
		}
		
		
		
		return 0;
	}

}
