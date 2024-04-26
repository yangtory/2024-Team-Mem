package com.callor.hello.service;

import com.callor.hello.models.CompanyVO;
import com.callor.hello.models.UserCompVO;
import com.callor.hello.models.UserVO;

public interface UserService {
	
	public UserVO createUser(UserVO createUserVO);
	
	public UserVO findById(String username);
	
	public String createCCode();

	public UserCompVO codeInput(UserVO userVO, UserCompVO userCompVO);

	public CompanyVO cNameCheck(String cname);

	
}
