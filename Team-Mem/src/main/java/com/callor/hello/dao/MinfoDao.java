package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.MinfoVO;

public interface MinfoDao {

	@Select(" SELECT * FROM tbl_minfo WHERE i_ccode = #{cCdoe} ")
	public List<MinfoVO> selectAll(String cCode);

	public int insert(MinfoVO vo);

	@Select(" SELECT * FROM tbl_minfo WHERE i_seq = #{seq}")
	public MinfoVO findById(String seq);

	public void update(MinfoVO vo);

	@Delete(" DELETE FROM tbl_minfo WHERE i_seq = #{seq} ")
	public void delete(String seq);
}
