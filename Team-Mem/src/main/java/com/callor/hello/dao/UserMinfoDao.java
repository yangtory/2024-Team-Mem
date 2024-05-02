package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.hello.models.UserMinfoVO;

public interface UserMinfoDao {

	public List<UserMinfoVO> selectAll(String ccode);

	public int insert(UserMinfoVO userMinfoVO);

	public int delete(String seq);

	public List<UserMinfoVO> findById(String seq);
	
	public UserMinfoVO findBySeq(String seq);

	public int update(@Param("vo") List<UserMinfoVO> vo, @Param("seq") String i_seq);

}
