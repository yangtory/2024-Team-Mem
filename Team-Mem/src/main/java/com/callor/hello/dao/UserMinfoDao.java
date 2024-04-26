package com.callor.hello.dao;

import java.util.List;
import com.callor.hello.models.UserMinfoVO;

public interface UserMinfoDao {

	public List<UserMinfoVO> selectAll(String ccode);

	public int insert(UserMinfoVO userMinfoVO);

	public int delete(String seq);

	public UserMinfoVO findById(String seq);

}
