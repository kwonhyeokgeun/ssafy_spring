package com.mycom.myapp.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
		
		BusinessProcess bp = (BusinessProcess)context.getBean("businessProcess");
		bp.bp();
		
		bp.int_bp();
		
		bp.int_String_bp("a",1,"b");
		
	}

}
