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
	private String t_code;		// VARCHAR(10)		PRIMARY KEY,
	private String t_name;		// VARCHAR(10)	NOT NULL	,
	private String t_tel;		// VARCHAR(15)	NOT NULL	,
}
