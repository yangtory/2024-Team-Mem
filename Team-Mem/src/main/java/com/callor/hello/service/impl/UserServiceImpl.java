package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.CompanyDao;
import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.CompanyVO;
import com.callor.hello.models.RoleVO;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private final PasswordEncoder passEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;
	private final CompanyDao companyDao; 

	public UserServiceImpl(
			@Qualifier("passEncorderV1") PasswordEncoder passEncoder, 
			UserDao userDao, RoleDao roleDao, CompanyDao companyDao) {
		super();
		this.passEncoder = passEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.companyDao = companyDao;
	}

	@Transactional
	@Override
	public UserVO createUser(UserVO createUserVO) {
		String username = createUserVO.getU_id();
		String password = createUserVO.getU_password();
		String company = createUserVO.getU_comp();
		
		// 회원가입 시 입력한 password 를 암호화 하기
		String encPassword = passEncoder.encode(password);
		// 암호화된 password 를 set 해주기 
		createUserVO.setU_password(encPassword);
		
		List<RoleVO> roles = new ArrayList<>();
		List<CompanyVO> comp = new ArrayList<>();
		
		if(company.isBlank()) {
			roles.add(RoleVO.builder()
					.r_uid(username)
					.r_role("ROLE_USER").build());
		} else {
			roles.add(RoleVO.builder()
					.r_uid(username)
					.r_role("ROLE_ADMIN").build());
			comp.add(CompanyVO.builder()
					.c_code("C0001")
					.c_name(company)
					.c_uid(username).build());
		}
		userDao.insert(createUserVO);
		roleDao.insertAll(roles);
		companyDao.createCompany(comp);
		
		return null;
	}

	@Override
	public UserVO findById(String username) {
		return userDao.findById(username);
	}

}
