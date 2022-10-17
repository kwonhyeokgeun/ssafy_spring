package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//xml로 하는걸 java로 표현

@Configuration // <= spring이 인식하는 설정 클래스
public class CalcConfiguration {
	
	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
}
