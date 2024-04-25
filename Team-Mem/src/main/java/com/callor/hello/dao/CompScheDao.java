package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CompScheVO;
import com.callor.hello.models.ScheduleVO;

public interface CompScheDao {

	@Select(" SELECT * FROM tbl_comp_sche WHERE cs_code = #{c_code}")
	List<CompScheVO> selectAll(ScheduleVO vo);

	
	
}
