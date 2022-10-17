package com.mycom.myapp.calc.hasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseCalculator {
	
	//1번째 방법
	//@Autowired//이 필드에 Calculator 객체를 만들어 달라는 뜻, 그래서 이게 없으면 null point 에러남
	//Calculator calculator;
	
	
	//2번째 방법
	//@Autowired
	//public void setCalculator(Calculator calculator) {
	//	this.calculator = calculator;
	//}
	
	
	//3번째 방법
	Calculator calculator;
	@Autowired
	public UseCalculator(Calculator calculator) {
		this.calculator=calculator;
	}
	
	
	
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
}
