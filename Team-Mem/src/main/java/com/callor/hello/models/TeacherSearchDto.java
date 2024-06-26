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
public class TeacherSearchDto {
	private String tname;		// VARCHAR(10)	NOT NULL	,
	private String tcode;		// VARCHAR(10)		PRIMARY KEY,
	private String ttel;		// VARCHAR(15)	NOT NULL	,
	private String t_ccode;
}
