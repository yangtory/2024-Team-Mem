package com.callor.hello.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.hello.dao.TeacherDao;
import com.callor.hello.models.TeacherVO;
import com.callor.hello.service.TeacherService;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
	
	private final TeacherDao teacherDao;
	public TeacherServiceImpl(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public String createTCode() {
		String tCode = "T0001";
		List<TeacherVO>list = teacherDao.selectAll(); 
		if(!list.isEmpty()) {
			tCode = list.get(list.size()-1).getT_code();
			String prefix = tCode.substring(0,1);
			tCode = tCode.substring(1);
			tCode = String.format("%s%04d", prefix, Integer.valueOf(tCode)+1);
		}
		return tCode;
	}

}
