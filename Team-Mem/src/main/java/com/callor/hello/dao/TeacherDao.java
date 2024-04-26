package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.TeacherSearchDto;
import com.callor.hello.models.TeacherVO;

public interface TeacherDao {
	
	@Select("SELECT * FROM tbl_teacher ")
	public List<TeacherVO> selectAll();

	public List<TeacherVO> selectSearchAll(TeacherSearchDto teacherSearchDto);
	public List<TeacherVO> selectcomp(String comp);
	
	


	public int insert(TeacherVO teacherVO);

	public List<String> findByComp(String uid);

	public TeacherVO findById(String tcode);

	public List<TeacherVO> select(String tccode);

	public void update(TeacherVO vo);

	@Delete("DELETE FROM tbl_teacher WHERE t_code = #{tcode}")
	public void delete(String tcode);

	@Select("SELECT * FROM tbl_teacher WHERE t_ccode = #{comp}")
	public List<TeacherVO> selectAllComp(String comp);

	

	
}
