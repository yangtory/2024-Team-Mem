package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.models.RoleVO;
import com.callor.hello.models.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider{

	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;

	public AuthProviderImpl(@Qualifier("passEncorderV1") PasswordEncoder passwordEncoder, UserDao userDao, RoleDao roleDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		log.debug("로그인한 사용자 정보 {}, {}", username, password);
		
		UserVO userVO = userDao.findById(username);
		if(userVO == null) {
			throw new UsernameNotFoundException(String.format("USERNAME 없음"));
		}
		
		boolean passOK = passwordEncoder.matches(password, userVO.getU_password());
		if(!passOK) {
			throw new BadCredentialsException("비밀번호 확인 필요");
		}
		
		List<RoleVO> roles = roleDao.findByUserName(username);
		List<GrantedAuthority>grantList = new ArrayList<GrantedAuthority>();
		
		for(RoleVO r : roles) {
			grantList.add(new SimpleGrantedAuthority(r.getR_role()));
		}
		
		Authentication token = new UsernamePasswordAuthenticationToken(userVO, password,grantList);
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
