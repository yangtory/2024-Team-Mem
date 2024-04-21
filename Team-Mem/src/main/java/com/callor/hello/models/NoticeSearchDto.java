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
public class NoticeSearchDto {
	private String title;
	private String date;
	private String num;
	private String ccode;
}
