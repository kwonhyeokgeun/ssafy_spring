package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value="/book") 이걸 해놓으면 http://localhost:8080/myapp/book/~~ 를 받음
public class UrlMappingController {

	
	@RequestMapping("/hello")
	public void m1() {
		// url : http://localhost:8080/myapp/hello
		System.out.println("/hello");
		//return "hello"; 를 안해줘도 void는 디폴트가 기존 url을 리턴해줌
	}
	
	@RequestMapping("/hello/ssafy")
	public void m2() {
		// url : http://localhost:8080/myapp/hello/ssafy
		System.out.println("/hello/ssafy");
	}
	
	@RequestMapping(value= {"/url1","/url2"}) //두  url 가능
	public void m3() {
		System.out.println("/url1 or url2");
	}
	
	@RequestMapping(value="/method",method=RequestMethod.GET)
	public void m4() {
		System.out.println("/method/GET");
	}
	
	@RequestMapping(value="/method",method=RequestMethod.POST)
	public void m5() {
		System.out.println("/method/POST");
	}
	
	@RequestMapping(value="/book/{bookNo}/and/{bookTitle}",method=RequestMethod.GET)
	public void m6(@PathVariable int bookNo, @PathVariable String bookTitle) {
		// url : http://localhost:8080/myapp/book/1/and/ssafy
		System.out.println("/book get");
		System.out.println(bookNo +", "+bookTitle);
	}
	
	
	@RequestMapping("/sub/*")
	public void m7() {
		// url : http://localhost:8080/myapp/sub/abc
		System.out.println("/sub/*");
	}
	
	@RequestMapping("/sub/**")
	public void m8() {
		// url : http://localhost:8080/myapp/sub/abc/abc
		// url : http://localhost:8080/myapp/sub/abc/abc/abc
		System.out.println("/sub/**");
	}
}
