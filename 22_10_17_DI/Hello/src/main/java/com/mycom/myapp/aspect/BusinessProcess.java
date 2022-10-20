package com.mycom.myapp.aspect;

import org.springframework.stereotype.Component;

@Component
public class BusinessProcess {
	public void bp() {
		//log code가 있어야할 위치지만 AOP를 이용해서 log를 남기려고함
		System.out.println("businessProcess : bp() is called");
	}
	
	public void no_bp() {
		System.out.println("businessProcess : no_bp() is called");
	}
	
	public int int_bp() {
		System.out.println("businessProcess : int_bp() is called");
		return 0;
	}
	
	public int int_String_bp(String s1, int i, String s2) {
		System.out.println("businessProcess : int_String_bp() is called");
		return 0;
	}
}
