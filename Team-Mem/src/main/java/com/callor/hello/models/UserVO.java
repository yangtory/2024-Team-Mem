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
public class UserVO {
	
	private String u_id;		// VARCHAR(20)		PRIMARY KEY,
	private String u_password;	// VARCHAR(20)	NOT NULL	,
	private String u_name;		// VARCHAR(10)	NOT NULL	,
	private String u_tel;		// VARCHAR(15)	NOT NULL	,
	private String u_comp;		// VARCHAR(10)	NOT NULL	
	

}
