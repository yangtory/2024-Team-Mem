package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CompanyVO;
import com.callor.hello.models.TeacherSearchDto;
import com.callor.hello.models.TeacherVO;
import com.callor.hello.models.UserVO;

public interface TeacherDao {
	
//	public List<TeacherVO> selectAll(String comp);

	public List<TeacherVO> selectSearchAll(TeacherSearchDto teacherSearchDto, String comp);

	public int insert(TeacherVO teacherVO);

	public String findByComp(String uid);

	public TeacherVO findById(String tcode);
}
