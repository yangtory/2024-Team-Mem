package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.UserCompVO;

public interface UserCompDao {

	
	@Select(" SELECT * FROM tbl_user_comp ")
	public List<UserCompVO> selectAll();
	
	
}
