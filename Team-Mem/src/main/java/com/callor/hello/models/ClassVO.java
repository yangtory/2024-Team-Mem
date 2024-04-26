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
public class ClassVO {
	
	private int c_seq;			// INT PRIMARY KEY AUTO_INCREMENT,
	private String c_name;		// VARCHAR(50)	NOT NULL	,
	private String 	c_sdate;		// VARCHAR(15)	NOT NULL	,
	private String 	c_edate;		// VARCHAR(15)	NOT NULL	,
	private String c_stime;		// VARCHAR(15)	NOT NULL,
	private String c_etime;		// VARCHAR(15) NOT NULL,
	private String c_tcode;		// VARCHAR(10) NOT NULL,
	private String c_ccode;		// VARCHAR(10) NOT NULL

}
