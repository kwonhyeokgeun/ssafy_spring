package com.mycom.more.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{ //xml 설정을 대신함(servlet-context.xml의 설정내용을 대체)
	//interceptor에 대한 정책
	//interceptor 객체 DI
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor) //이걸 인터셉터로 쓸거임
		.addPathPatterns("/users/**") //여기 url에 모두 개입함
		.excludePathPatterns("/login/**"); //이거는 예외로 둬서 개입 안함
	}
	
	
}
