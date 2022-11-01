package com.mycom.more.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(
		origins="http://127.0.0.1:5500", //VS코드로 들어갔을 때 포트
		allowCredentials = "true", //sessionid 기존처럼 고정 -> server session 계속 사용
		allowedHeaders="*",
		methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  //이것들 허용해 주는듯
				RequestMethod.OPTIONS, RequestMethod.HEAD
		}
)

@RestController // 무조건 json response
public class InterceptorTestController {

	@GetMapping("/login") // login 페이지 이동 효과
	public String m1() {
		System.out.println("/login");
		return "/login"; // jsp 로 분기 X 그냥 문자열 그대로 json 으로 response
	}
	
	@GetMapping("/login/ok") // login 성공 효과
	public String m2(HttpSession session) {
		System.out.println("/login/ok");
		session.setAttribute("login", "success");
		return "/login/ok"; // jsp 로 분기 X 그냥 문자열 그대로 json 으로 response
	}
	
	@GetMapping("/logout") // logout 효과
	public String m3(HttpSession session) {
		System.out.println("/logout");
		session.invalidate();
		return "/logout"; // jsp 로 분기 X 그냥 문자열 그대로 json 으로 response
	}
	
	@GetMapping("/users") // 일반 로그인 성공후 갈 수 있는 페이지 효과
	public String m4() {
		System.out.println("/users");
		return "/users"; // jsp 로 분기 X 그냥 문자열 그대로 json 으로 response
	}
}
