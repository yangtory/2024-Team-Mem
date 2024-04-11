package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.MinfoVO;

public interface MinfoDao {

	@Select(" SELECT * FROM tbl_minfo ")
	public List<MinfoVO> selectAll();
}
