package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.UserSearchDto;
import com.callor.hello.models.UserVO;

public interface UserDao {
	
	
	
	
	@Select(" SELECT * FROM tbl_user ")
	public List<UserVO> selectAll();
	
<<<<<<< HEAD
	public List<UserVO> selectCompany();
	
	public List<UserVO> selectSearchAll(UserSearchDto userSearchDto);

	
	
=======

	public List<UserVO> selectSearchAll(UserSearchDto userSearchDto);


	public void insert(UserVO createUserVO);

	@Select(" SELECT * FROM tbl_user WHERE u_id = #{username}")
	public UserVO findById(String username);
>>>>>>> 512f4d427f1e8fac9fa2dc1223909528dbb48f51
	
}
