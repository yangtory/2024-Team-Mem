package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.ClassVO;

public interface ClassDao {
	
	
	public List<ClassVO> selectAll(String code);

	public void insert(ClassVO vo);
	
	@Select(" SELECT * FROM tbl_class WHERE DATE(c_sdate) = #{sdate} AND c_ccode = #{code}")
	public List<ClassVO> findByClass(@Param("sdate") String sdate, @Param("code") String code);

	@Select(" SELECT * FROM tbl_class WHERE c_seq = #{seq} ")
	public ClassVO findBySeq(String seq);
	
	
	public ClassVO findByTname(String code);

}
