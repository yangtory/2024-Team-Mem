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
public class SalesSearchDto {
	private String s_sdate;
	private String s_edate;
	private String s_uid;	
	private String s_ititle;
	private String s_ccode;
}
