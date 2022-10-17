package com.mycom.myapp.calc.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AllCalculator {
	@Autowired
	@Qualifier("aaa") //calculator를 implements한 여러개중 aaa로 해논 걸쓰겠다
	Calculator calculator; //interface
	
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
}
