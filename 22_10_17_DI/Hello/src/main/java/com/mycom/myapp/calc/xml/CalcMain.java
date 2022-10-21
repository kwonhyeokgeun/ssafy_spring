package com.mycom.myapp.calc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// non-spring DI
		//Calculator calc = new Calculator();
		//System.out.println(calc.add(5, 6));
		
		
		//spring DI 사용
		//spring 환경 구성
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-xml.xml");
		
		Calculator calculator = (Calculator)context.getBean("calculator"); //bean에서 지장한 id
		System.out.println(calculator.add(5, 7));
	}

}
