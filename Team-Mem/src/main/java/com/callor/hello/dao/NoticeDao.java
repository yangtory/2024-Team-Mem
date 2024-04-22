package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.models.NoticeSearchDto;
import com.callor.hello.models.NoticeVO;

public interface NoticeDao {

	List<NoticeSearchDto> selectSearchAll(NoticeSearchDto noticeSearchDto);

	int insert(NoticeVO vo);

}
