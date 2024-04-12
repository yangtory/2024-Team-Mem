package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class UserSearchDto {

	private String uid;		// VARCHAR(20)		PRIMARY KEY,
	
	private String uname;		// VARCHAR(10)	NOT NULL	,
	private String utel;		// VARCHAR(15)	NOT NULL	,
	
	
}
