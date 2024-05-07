package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.UserMinfoVO;

public interface UserMinfoDao {

	public List<UserMinfoVO> selectAll(String ccode);

	public int insert(UserMinfoVO userMinfoVO);

	public int delete(String seq);

	public List<UserMinfoVO> findById(String seq);
	
	public UserMinfoVO findBySeq(String seq);

	public int update(UserMinfoVO updateVO);

	public int tickdelete(@Param("id") String id,@Param("seq") String seq);
	
	public int countUser(@Param("ccode") String ccode,@Param("seq") String seq);

	public Integer total(String ccode);

	public int checkMinfo(@Param("id") String id,@Param("seq") String seq);

	

}
