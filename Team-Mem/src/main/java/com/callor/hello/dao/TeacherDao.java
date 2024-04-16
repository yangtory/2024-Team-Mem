package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.TeacherSearchDto;
import com.callor.hello.models.TeacherVO;
import com.callor.hello.models.UserVO;

public interface TeacherDao {
	
	@Select(" SELECT * FROM tbl_teacher ")
	public List<TeacherVO> selectAll();

	public List<TeacherVO> selectSearchAll(TeacherSearchDto teacherSearchDto);

	public int insert(TeacherVO teacherVO);
}
