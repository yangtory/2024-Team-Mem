package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.MinfoVO;

public interface MinfoDao {

	@Select(" SELECT * FROM tbl_minfo WHERE i_ccode = #{cCdoe} ")
	public List<MinfoVO> selectAll(String cCode);

	public int insert(MinfoVO vo);
}
