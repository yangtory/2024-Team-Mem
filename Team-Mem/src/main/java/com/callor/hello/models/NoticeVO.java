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
public class NoticeVO {
	
	private String n_seq;	
	private String n_date;
	private String n_time;
	private String n_title;		// VARCHAR(125)	NOT NULL	,
	private String 	n_content;		// VARCHAR(255)	NOT NULL,
	private String n_ccode;		// VARCHAR(10) NOT NULL,
	private String n_uid;		// VARCHAR(20) NOT NULL

}
