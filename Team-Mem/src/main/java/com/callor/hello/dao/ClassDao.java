package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.ClassVO;

public interface ClassDao {
	
	@Select(" SELECT * FROM tbl_class")
	public List<ClassVO> selectAll();

}
