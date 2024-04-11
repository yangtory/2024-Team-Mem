package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CompanyVO;

public interface CompanyDao {
	
	@Select(" SELECT * FROM tbl_company ")
	public List<CompanyVO> selectAll();

}
