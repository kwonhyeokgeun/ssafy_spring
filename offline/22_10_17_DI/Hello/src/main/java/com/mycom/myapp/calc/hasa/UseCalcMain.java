package com.mycom.myapp.calc.hasa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.myapp.calc.annotation.Calculator;

public class UseCalcMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("use-calc-annotation.xml");
		UseCalculator useCalculator = (UseCalculator)context.getBean("useCalculator"); //이름, 없으면 default로 드가짐
		System.out.println(useCalculator.add(5, 7));

	}

}
