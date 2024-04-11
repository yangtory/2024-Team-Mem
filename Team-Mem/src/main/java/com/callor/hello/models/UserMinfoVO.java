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
public class UserMinfoVO {

	
	private int r_iseq;			// INT NOT NULL,
	private String r_uid;		// VARCHAR(20)	NOT NULL,
	private String 	r_sdate;	// VARCHAR(15)	NOT NULL,
	private String r_edate;		// VARCHAR(15)	NOT NULL,
//	CONSTRAINT mi_pk PRIMARY KEY(r_iseq,r_uid)
}
