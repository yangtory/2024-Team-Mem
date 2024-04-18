package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CompanyVO;
import com.callor.hello.models.UserCompVO;

public interface UserCompDao {

	
	@Select(" SELECT * FROM tbl_user_comp WHERE us_ccode = 'C001' ")
	public List<UserCompVO> selectAll();

	public int insert(UserCompVO userCompVO);
	
	public int createUser(List<UserCompVO> comp);

	@Select(" SELECT * FROM tbl_user_comp WHERE us_uid = #{us_uid} ")
	public UserCompVO findById(String us_uid);


}
