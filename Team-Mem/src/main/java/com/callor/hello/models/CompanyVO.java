package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CompanyVO {

	private String c_code;		// VARCHAR(10)		PRIMARY KEY,
	private String c_name;		// VARCHAR(10)	NOT NULL	,
	private String c_addr;		// VARCHAR(10)		,
	private String c_tel;		// VARCHAR(15)		,
	private String c_uid;		// VARCHAR(20)
	
}
