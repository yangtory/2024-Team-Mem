package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.UserVO;

public interface UserDao {
	
	@Select(" SELECT * FROM tbl_user WHERE u_comp = '' ")
	public List<UserVO> selectAll();

	public int insert(UserVO createUserVO);

	@Select(" SELECT * FROM tbl_user WHERE u_id = #{username}")
	public UserVO findById(String username);
	
}
