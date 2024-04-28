package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.hello.models.ScheduleVO;

public interface ScheduleDao {

	@Select(" SELECT * FROM tbl_schedule WHERE s_ccode = #{code} ORDER BY  s_sdate ASC, s_edate DESC ")
	public List<ScheduleVO> selectAll(String code);
	
	@Select(" SELECT * FROM tbl_schedule WHERE s_sdate = #{s_sdate} ")
	public ScheduleVO findBydate(String sdate);
	
	@Select(" SELECT * FROM tbl_schedule WHERE s_seq = #{s_seq} ")
	public ScheduleVO findByseq(String seq);
	
	// @param 을 사용하면 세션에 담긴 code를 가져올수있음
	@Select("SELECT * FROM tbl_schedule WHERE DATE(s_sdate) = #{sdate} AND s_ccode = #{code}")
	public List<ScheduleVO> findByDate(@Param("sdate") String sdate, @Param("code") String code);

	
	@Insert(" INSERT INTO tbl_schedule ( s_title, s_content, s_sdate, s_edate, s_ccode ) VALUES (#{s_title}, #{s_content}, #{s_sdate}, #{s_edate}, #{s_ccode} )")
	public int insert(ScheduleVO vo);
	
	@Update(" UPDATE tbl_schedule SET s_title = #{s_title}, s_content = #{s_content}, s_sdate = #{s_sdate}, s_edate = #{s_edate} WHERE s_seq = #{s_seq} ")
	public void update(ScheduleVO vo);
	
	@Delete(" DELETE FROM tbl_schedule WHERE s_seq = #{s_seq}")
	public int delete(ScheduleVO vo);
	
}
