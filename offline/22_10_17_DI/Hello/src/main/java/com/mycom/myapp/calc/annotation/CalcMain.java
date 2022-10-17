package com.mycom.myapp.calc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// non-spring DI
		//Calculator calc = new Calculator();
		//System.out.println(calc.add(5, 6));
		
		
		//spring DI 사용
		//spring 환경 구성
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-annotation.xml");
		
		Calculator calculator = (Calculator)context.getBean("calculator"); //이름, 없으면 default로 드가짐
		System.out.println(calculator.add(5, 7));
	}

}
