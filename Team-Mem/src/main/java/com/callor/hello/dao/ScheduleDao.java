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
	
	// 매개변수가 많을때 @Param을 사용해줘야함
	@Select("SELECT * FROM tbl_schedule WHERE DATE(s_sdate) = #{sdate} AND s_ccode = #{code}")
	public List<ScheduleVO> findByDate(@Param("sdate") String sdate, @Param("code") String code);

	
	@Insert(" INSERT INTO tbl_schedule ( s_title, s_content, s_sdate, s_edate, s_ccode, s_color ) VALUES (#{s_title}, #{s_content}, #{s_sdate}, #{s_edate}, #{s_ccode}, #{s_color} )")
	public int insert(ScheduleVO vo);
	
	@Update(" UPDATE tbl_schedule SET s_title = #{s_title}, s_content = #{s_content}, s_sdate = #{s_sdate}, s_edate = #{s_edate}, s_color = #{s_color} WHERE s_seq = #{s_seq} ")
	public void update(ScheduleVO vo);
	
	@Delete(" DELETE FROM tbl_schedule WHERE s_seq = #{s_seq}")
	public int delete(ScheduleVO vo);

	@Select ("SELECT * FROM tbl_schedule WHERE s_ccode = #{code} AND SUBSTRING(s_sdate, 1,7) = #{currentMonth} ")
	public List<ScheduleVO> selectByMonth(@Param("currentMonth") String currentMonth, @Param("code") String code);
	
	
	
}
