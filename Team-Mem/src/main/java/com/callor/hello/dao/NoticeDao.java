package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.models.NoticeSearchDto;

public interface NoticeDao {

	List<NoticeSearchDto> selectSearchAll(NoticeSearchDto noticeSearchDto);

}
