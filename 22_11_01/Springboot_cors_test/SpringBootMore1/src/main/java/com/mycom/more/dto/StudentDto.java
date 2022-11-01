package com.mycom.more.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//lombok은 setter, getter를 자동으로 생성해주는 library인데 이게 가능하려면 ide - sts 와 lombaok library가 소통해야함
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {
	private int studentId;
	private String studentNm;
	private String email;
	private String phone;
}
