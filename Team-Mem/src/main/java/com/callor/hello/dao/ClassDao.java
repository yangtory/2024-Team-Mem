package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.ClassVO;
import com.callor.hello.models.TeacherVO;

public interface ClassDao {
	
	@Select(" SELECT * FROM tbl_class WHERE c_ccode = #{code} ORDER BY  c_sdate ASC, c_edate DESC ") 
	public List<ClassVO> selectAll(String code);

	public int insert(ClassVO vo);

	public List<ClassVO> findByClass(@Param("sdate") String sdate, @Param("code") String code);
	
	public ClassVO findBySeq(String seq);
	
	public ClassVO findByTname(String code);
	
	public int update(ClassVO vo);
	
	@Delete(" DELETE FROM tbl_class WHERE c_seq = #{c_seq} ")
	public int delete(ClassVO vo);

	public TeacherVO findTeacher(@Param("tcode") String tcode);
	

}
