package com.mycom.myapp.calc.all;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// non-spring DI
		//Calculator calc = new Calculator();
		//System.out.println(calc.add(5, 6));
		
		
		//spring DI 사용
		//spring 환경 구성
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("all-calc-annotation.xml");
		
		AllCalculator allCalculator = (AllCalculator)context.getBean("allCalculator"); //이름, 없으면 default로 드가짐
		System.out.println(allCalculator.add(5, 7));
	}

}
