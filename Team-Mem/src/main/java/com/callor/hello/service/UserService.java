package com.callor.hello.service;

import com.callor.hello.models.UserVO;

public interface UserService {
	
	public UserVO createUser(UserVO createUserVO);
	
	public UserVO findById(String username);
	

}
