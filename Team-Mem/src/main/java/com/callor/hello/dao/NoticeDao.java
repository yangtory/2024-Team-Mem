package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.callor.hello.models.NoticeSearchDto;
import com.callor.hello.models.NoticeVO;

public interface NoticeDao {

	public List<NoticeSearchDto> selectSearchAll(NoticeSearchDto noticeSearchDto);
	public NoticeVO findById(String seq);

	public int insert(NoticeVO vo);
	public int update(NoticeVO vo);
	
	@Delete("DELETE FROM tbl_notice WHERE n_seq = #{seq}")
	public int delete(String seq);


}
