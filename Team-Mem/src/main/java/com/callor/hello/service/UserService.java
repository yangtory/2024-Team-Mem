package com.callor.hello.service;

import com.callor.hello.models.UserCompVO;
import com.callor.hello.models.UserVO;

public interface UserService {
	
	public UserVO createUser(UserVO createUserVO);
	
	public UserVO findById(String username);
	
	public String createCCode();

	UserCompVO codeInput(UserVO userVO, UserCompVO userCompVO);

	
}
