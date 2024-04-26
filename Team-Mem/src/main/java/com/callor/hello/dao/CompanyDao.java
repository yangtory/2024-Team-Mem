package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CompanyVO;

public interface CompanyDao {
	
	@Select(" SELECT * FROM tbl_company ")
	public List<CompanyVO> selectAll();
	
	public int createCompany(List<CompanyVO> comp);

	@Select(" SELECT c_code FROM tbl_company")
	public String findCode(List<CompanyVO>list);

	@Select(" SELECT c_name FROM tbl_company WHERE c_code = #{ccode} ")
	public String findCname(String ccode);

	@Select(" SELECT * FROM tbl_company WHERE c_name = #{cname}")
	public CompanyVO checkCname(String cname);

}
