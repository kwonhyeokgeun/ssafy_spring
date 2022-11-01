package com.mycom.myboard.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycom.myboard.dto.UserDto;

@Component
public class LoginInterceptor implements HandlerInterceptor {

// DispatcherServlet 이후 다른 Controller의 메소드를 실행하기 직전에 호출
// 뭔가 테스트를 진행하고 그 결과에 따라 return true 하면 Controller 로 진행
// return false 하면ㅁ Controller 로 진행 X => empty response 를 Client에 보낸다.

// 테스트 하려는 항목이 뭔가!! => 이곳 코드안에서 처리/판단
// 이걸 누구에게 적용할 것인가?? => 설정을 통해서 servlet-context.xml 지정

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	        throws Exception {
	
	    System.out.println("LoginInterceptor : preHandler !!!"); // 나중에 interceptor에서 문제시 확인하기 쉽게 sout
	    
	    // #1 무조건 통과 test
	    //return true;
	    
	    /*
	    // #2 login test
	    HttpSession session = request.getSession();
	    UserDto userDto = (UserDto) session.getAttribute("userDto");
	    
	    // logout 상태
	    if(userDto ==null) { 
	    	System.out.println("비로그인 상태라 로그인으로 보냄");
	    	response.sendRedirect("/login");
	        return false;
	    }
	
	    // login 상태
	    return true;*/
	    
	    //#3 page요청과 async요청에 대한 처리를 따로 구성
	    //async 요청인지 확인
	    String async = request.getHeader("async");
	    HttpSession session = request.getSession();
	    UserDto userDto = (UserDto)session.getAttribute("userDto");
	    
	    if(userDto ==null) {
	    	if("true".equals(async)) {
	    		//json으로 session timeout = > login 이동하라는 내용을 만들어서 보낸다.
	    		Gson gson = new Gson();
	    		JsonObject jsonObject =  new JsonObject();
	    		jsonObject.addProperty("result", "login"); //jsp에서 화면이동하라고 result를 login으로 보냄
	    		String jsonStr = gson.toJson(jsonObject);
	    		response.getWriter().write(jsonStr);
	    	}else {
	    		response.sendRedirect("/login");
	    	}
	    	return false;
	    }
	    return true;
	}

}

