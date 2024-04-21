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
public class UserCompSearchDto {

	private String uid;
	
	private String uname;
	private String utel;
	
}
