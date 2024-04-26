package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.hello.dao.ClassDao;
import com.callor.hello.dao.ScheduleDao;
import com.callor.hello.models.ClassVO;
import com.callor.hello.models.ScheduleVO;
import com.callor.hello.service.ScheduleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {

	private final ScheduleDao scheduleDao;
	private final ClassDao classDao;

	public ScheduleServiceImpl(ScheduleDao scheduleDao, ClassDao classDao) {
		super();
		this.scheduleDao = scheduleDao;
		this.classDao = classDao;
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
		
		} else {
			list.add(vo.builder()
					.s_title(s_title)
					.s_content(s_content)
					.s_sdate(s_sdate)
					.s_edate(s_edate).build());
		
			scheduleDao.insert(vo);
			
		}
		
		
		
		return 0;
	}


	@Override
	public int insertDate(ClassVO vo) {
		String c_sdate = vo.getC_sdate();
		String c_edate = vo.getC_edate();
		String c_tcode = "T0001";
		List<ClassVO> list = new ArrayList<>();
		if(c_edate.isEmpty()) {
			list.add(vo.builder()

					.build());
			vo.setC_edate(c_sdate);
			vo.setC_tcode(c_tcode);
			classDao.insert(vo);
		
		} else {
			list.add(vo.builder()
					.c_tcode(c_tcode)
					.c_sdate(c_sdate)
					.c_edate(c_edate).build());
			vo.setC_tcode(c_tcode);
			classDao.insert(vo);
			
		}
		
		
		
		return 0;
		
	}




}
