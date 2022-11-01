package com.mycom.myboard.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//비동기 요청을 처리하는 controller가 아님, 페이지 이동에 대한 역할을 수행함
@Controller
public class HomeController {
	
	
	@GetMapping(value = "/")
	public String home() {
		return "/index.html"; //staic 폴더의 index.html로 이동
		
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "/login.html";
		
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "/register.html";
		
	}
	
	@GetMapping(value = "/board")
	public String board() {
		return "/board/boardMain.html";
		
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/login.html";
		
	}
}
