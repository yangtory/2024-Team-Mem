package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CompanyVO;
import com.callor.hello.models.UserCompVO;

public interface UserCompDao {

	
	@Select(" SELECT * FROM tbl_user_comp WHERE us_ccode = #{us_ccode} ")
	public List<UserCompVO> selectAll(String us_ccode);

	public int insert(UserCompVO userCompVO);
	
	public int createUser(List<UserCompVO> comp);

	@Select(" SELECT * FROM tbl_user_comp WHERE us_uid = #{username} ")
	public UserCompVO findById(String us_uid);
	
	@Select(" SELECT c_code FROM tbl_company WHERE c_name = #{cname} ")
	public String findByCcode(String u_comp);

	public int update(UserCompVO VO);

	
	@Delete(" DELETE FROM tbl_user_comp WHERE us_uid = #{us_uid} ")
	public int delete(String seq);
	

}
