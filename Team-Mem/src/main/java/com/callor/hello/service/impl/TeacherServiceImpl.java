package com.callor.hello.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.TeacherDao;
import com.callor.hello.models.TeacherVO;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.TeacherService;

@Service("teacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
	
	private final TeacherDao teacherDao;
	public TeacherServiceImpl(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	// tcode 생성 
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

	// 로그인된 업체코드 가져오기 
	@Override
	public String getLoginCCode() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserVO userDetails = (UserVO) authentication.getPrincipal();
		String ucomp = userDetails.getU_comp();
		List<String> cCode = teacherDao.findByComp(ucomp);
		return cCode.get(0);
	}
	
	// 로그인된 유저 아이디 가져오기 
	@Override
	public String getLoginUid() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserVO userDetails = (UserVO) authentication.getPrincipal();
		String id = userDetails.getU_id().toString();
		return id;
	}
	
	// 공지사항의 seq uuid 로 만들기 
	@Override
	public String createNSeq() {
		String nSeq = UUID.randomUUID().toString();
		return nSeq;
	}

}
