package com.mycom.myapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//Spring에서 내부적으로 관리되어야하는 컴포넌트
@Component
//AOP를 처리하는 특별한 컴포넌트
@Aspect
public class LogAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); //log4j.xml에
	
	
	//BusinessProcess의 method에 끼어들려고 한다
	
	//PointCut으로 끼어들 method를 선택
	//PointCut은 메소드 signature를 이용
	
	@Pointcut(value="execution( * com.mycom.myapp.aspect.*.*(..) )") //return타입 - package - class - method( parameter ) 
	private void logPointCut() {} //어느 클래스의 어느 메소드에 끼어드는지 표현
	
	//advise를 이용해서 앞 뒤 등 메소드 호출별 시점을 지정
	@Before("logPointCut()") //logPointCut()이 호출되면 그 앞에 끼어듬
	public void beforeLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[sysout : before] 메소드이름 : "+signature.getName());
		logger.debug("[Logger : before] 메소드이름 : "+signature.getName()); //메세지를 logger를 통해서 debug level로 출력
	}
	
	@After("logPointCut()") //logPointCut()이 호출되면 그 뒤에 끼어듬
	public void afterLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[sysout : after] 메소드이름 : "+signature.getName());
		logger.debug("[Logger : after] 메소드이름 : "+signature.getName()); //메세지를 logger를 통해서 debug level로 출력
	}
	
	
	
	
	@Pointcut(value="execution( int com.mycom.myapp.aspect.*.*(String, int, String) )") //return타입 - package - class - method( parameter ) 
	private void logPointCut2() {} //어느 클래스의 어느 메소드에 끼어드는지 표현
	@Before("logPointCut2()") //logPointCut()이 호출되면 그 앞에 끼어듬
	public void beforeLog2(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("[sysout : before2] 메소드이름 : "+signature.getName());
		logger.debug("[Logger : before2] 메소드이름 : "+signature.getName()); //메세지를 logger를 통해서 debug level로 출력
	}
}
