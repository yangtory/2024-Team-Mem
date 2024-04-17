package com.callor.hello.service.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUtility {
	
	@Bean(name="passEncorderV1")
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
