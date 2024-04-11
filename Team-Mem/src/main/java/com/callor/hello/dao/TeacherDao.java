package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.TeacherVO;

public interface TeacherDao {
	
	@Select(" SELECT * FROM tbl_teacher ")
	public List<TeacherVO> selectAll();

}
