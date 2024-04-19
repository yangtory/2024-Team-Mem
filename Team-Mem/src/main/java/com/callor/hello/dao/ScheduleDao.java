package com.callor.hello.dao;

import org.apache.ibatis.annotations.Insert;

import com.callor.hello.models.ScheduleVO;

public interface ScheduleDao {

	@Insert(" INSERT INTO tbl_schedule ( s_title, s_content, s_sdate, s_edate ) VALUES (#{s_title}, #{s_content}, #{s_sdate}, #{s_edate} )")
	public int insert(ScheduleVO vo);
	
	
}
