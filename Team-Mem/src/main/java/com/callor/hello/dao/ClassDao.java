package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.ClassVO;

public interface ClassDao {
	
	@Select(" SELECT * FROM tbl_class WHERE c_ccode = #{code} ORDER BY  c_sdate ASC, c_edate DESC ") 
	public List<ClassVO> selectAll(String code);

	public int insert(ClassVO vo);
	
//	@Select(" SELECT * FROM tbl_class LEFT JOIN tbl_teacher ON c_tcode = #{code} WHERE DATE(c_sdate) = #{sdate} AND c_ccode = #{code}")
	public List<ClassVO> findByClass(@Param("sdate") String sdate, @Param("code") String code);

	
	public ClassVO findBySeq(String seq);
	
	
	public ClassVO findByTname(String code);
	
	public int update(ClassVO vo);

}
