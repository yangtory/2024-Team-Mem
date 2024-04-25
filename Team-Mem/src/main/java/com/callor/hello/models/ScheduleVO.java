package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ScheduleVO {

	private int s_seq; // INT PRIMARY KEY AUTO_INCREMENT,
	private String 	s_title; // VARCHAR(50)	NOT NULL	,
	private String s_content; // VARCHAR(125),
	private String 	s_sdate; // VARCHAR(15) 	,
	private String s_edate; // VARCHAR(15)	
	private String s_ccode; // VARCHAR(10)
}
