package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.CompanyDao;
import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserCompDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.CompanyVO;
import com.callor.hello.models.RoleVO;
import com.callor.hello.models.UserCompVO;
import com.callor.hello.models.UserVO;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServiceImpl implements UserService{
	private final PasswordEncoder passEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;
	private final CompanyDao companyDao; 
	private final UserCompDao userCompDao;

	public UserServiceImpl(
			@Qualifier("passEncorderV1") PasswordEncoder passEncoder, 
			UserDao userDao, RoleDao roleDao, CompanyDao companyDao, UserCompDao userCompDao) {
		super();
		this.passEncoder = passEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
		this.companyDao = companyDao;
		this.userCompDao = userCompDao;
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
			userDao.insert(createUserVO);
			roleDao.insertAll(roles);
		} else {
			roles.add(RoleVO.builder()
					.r_uid(username)
					.r_role("ROLE_ADMIN").build());
			comp.add(CompanyVO.builder()
					.c_code(createCCode())
					.c_name(company)
					.c_uid(username).build());
			userDao.insert(createUserVO);
			companyDao.createCompany(comp);
			roleDao.insertAll(roles);
		}
		
		return null;
	}

	@Override
	public UserVO findById(String username) {
		return userDao.findById(username);
	}



	// 업체코드 생성하기 
	@Override
	public String createCCode() {
		String cCode = "C0001";
		List<CompanyVO> list = companyDao.selectAll();
		if(!list.isEmpty()) {
			cCode = list.get(list.size()-1).getC_code();
			String prefix = cCode.substring(0,1);
			cCode = cCode.substring(1);
			cCode = String.format("%s%04d", prefix, Integer.valueOf(cCode)+1);
		}
		return cCode;
	}

	@Override
	public UserCompVO codeInput(UserVO userVO, UserCompVO userCompVO) {
	    String user = userCompVO.getUs_uid();
	    String username = userCompVO.getUs_uname();
	    String cname = userCompVO.getUs_cname();
	    String ustel = userCompVO.getUs_utel();
	    
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.getPrincipal() instanceof UserVO) {
			UserVO list = (UserVO)authentication.getPrincipal();
			String ucomp = list.getU_comp();
			 log.debug("사용자의 업체명 service {}",ucomp);
			 String comp = userCompDao.findByCcode(ucomp);
			 log.debug("사용자의 업체코드 service {}",comp);
			 List<UserCompVO> ucList = new ArrayList<>();
			 
			    if (!user.isBlank()) {
			    	ucList.add(userCompVO.builder()
			    			.us_uid(user)
			    			.us_uname(username)
			    			.us_ccode(comp)
			    			.us_cname(cname)
			    			.us_utel(ustel).build()
			    			);
			    	userCompDao.createUser(ucList);
			    }
			 
		}
		
		return null;
	}







	
	

	

}
