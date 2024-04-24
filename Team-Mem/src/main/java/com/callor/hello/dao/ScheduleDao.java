package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.ScheduleVO;

public interface ScheduleDao {

	@Select(" SELECT * FROM tbl_schedule ORDER BY  s_sdate ASC, s_edate DESC ")
	public List<ScheduleVO> selectAll();
	
	@Select(" SELECT * FROM tbl_schedule WHERE s_sdate = #{s_sdate} ")
	public ScheduleVO findBydate(String sdate);
	
	@Select("SELECT * FROM tbl_schedule WHERE DATE(s_sdate) = #{sdate}")
	public List<ScheduleVO> findByDate(String sdate);
	
	@Insert(" INSERT INTO tbl_schedule ( s_title, s_content, s_sdate, s_edate ) VALUES (#{s_title}, #{s_content}, #{s_sdate}, #{s_edate} )")
	public int insert(ScheduleVO vo);
	
	
}
