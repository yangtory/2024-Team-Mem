package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCompVO {

	private String us_uid;	// VARCHAR(20)	NOT NULL,
	private String us_ccode;	// VARCHAR(10)	NOT NULL,
	private String us_uname;	// VARCHAR(10)	,
	private String us_utel;	// VARCHAR(15)	,
	private String us_cname;	// VARCHAR(10)	,
	
	
}
