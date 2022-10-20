package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		//자바 configuration 클래스 이용
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		
		Calculator calculator = (Calculator)context.getBean("calculator"); 
		System.out.println(calculator.add(5, 7));
	}

}
