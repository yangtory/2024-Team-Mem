package com.callor.hello.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMinfoVO {
	
	private int r_iseq;	
	private String r_uid;
	private String r_icount;
	private String r_sdate;
	private String r_edate; 
	
	private int i_seq;			// INT PRIMARY KEY AUTO_INCREMENT,
	private String i_title;		// VARCHAR(50)	NOT NULL	,
	private int i_price;		// INT	NOT NULL	,
	private int i_count;		// INT	NOT NULL	,
	private String i_ccode;
	
	private String us_uid;
	
}
