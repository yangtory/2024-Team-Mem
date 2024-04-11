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
public class MinfoVO {
	
	private int i_seq;			// INT PRIMARY KEY AUTO_INCREMENT,
	private String i_title;		// VARCHAR(50)	NOT NULL	,
	private int i_price;		// INT	NOT NULL	,
	private int i_count;		// INT	NOT NULL	,
	private String i_sdate;		// VARCHAR(15) 	,
	private String i_edate;		// VARCHAR(15)	

}
