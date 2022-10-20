package com.mycom.myapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ParamController {

	@GetMapping("/param1")
	public void m1(HttpServletRequest request) {
		//url : http://localhost:8080/myapp/param1?seq=1234
		String seq = request.getParameter("seq");
		System.out.println(seq);
	}
	
	@GetMapping("/param2")
	public void m2(String seq) { //바로 param을 인자로 받아 쓸 수 있음
		//url : http://localhost:8080/myapp/param2?seq=1234
		System.out.println(seq);
	}
	
	@GetMapping("/param3")
	public void m3(@RequestParam(name="seq", required=false) String seq) { //필수가 아니라서 없어도 가능
		//url : http://localhost:8080/myapp/param3?seq=1234
		//url : http://localhost:8080/myapp/param3
		System.out.println("param3 "+seq);  //seq를 param으로 안넣어주면 null`
	}
	
	
	@GetMapping("/param4")
	public void m4(String name, int price) { 
		//url : http://localhost:8080/myapp/param4?name=1234&price=100   //잘됨 
		//url : http://localhost:8080/myapp/param4?price=100   -> name은 null로 출력 // 잘됨
		//url : http://localhost:8080/myapp/param4?name=1234   -> 에러남 price는 primitive 타입이라서
		//만약 인자로 Integer price 인 경우는 에러 안남
		System.out.println(name);
		System.out.println(price);
	}
	
	@GetMapping("/para5")
	public void m5(String name, Integer price) { //int 대신 Integer
		//url : http://localhost:8080/myapp/param4?name=1234&price=100   //잘됨 
		//url : http://localhost:8080/myapp/param4?price=100   -> name은 null로 출력 // 잘됨
		//url : http://localhost:8080/myapp/param4?name=1234   -> 에러는 안나지만 이 함수가 실행되지 않는듯
		System.out.println(name);
		System.out.println(price);
	}
	
	
	@GetMapping("/car1")
	public void car1(CarDto dto) { //바로 dto로 쉽게 받기
		//url : http://localhost:8080/myapp/car1?name=car&price=1000 ->당연히 에러안남, owner에 null들어감
		//url : http://localhost:8080/myapp/car1?name=car&owner=man ->에러 안남, price에 0들어감
		//name의 경우 dto.setName() 메소드를 자동으로 사용해서 값을 넣는다. 그래서 setName2()로 하면 안들어가짐
		System.out.println(dto);
		
	}
	
	@GetMapping("/car2")
	public void car2(CarDto dto,HttpServletRequest request) { //dto, request 둘다 쓰기 
		//url : http://localhost:8080/myapp/car2?name=car&price=1000 
		System.out.println(dto);
		String name = request.getParameter("name");
		System.out.println("name : "+name);  //출력잘됨
	}
	
	@GetMapping("/map")
	public void map(@RequestParam Map<String,String> params) { //map으로 쉽게 받기
		//url : http://localhost:8080/myapp/map?name=car&price=1000&owner=man
		System.out.println(params.get("name"));
		System.out.println(params.get("price"));
		System.out.println(params.get("owner"));
		
	}
	
	@GetMapping("/header")
	public void m6(@RequestHeader (value="Accept") String accept, @RequestHeader (value="Host") String host) { //헤더에서 Accept,Host를 인자로 받음
		//url : http://localhost:8080/myapp/header
		System.out.println(accept); 
		System.out.println(host);
		//헤더에 담겨있는 Accept, Host 정보가 찍혀나옴
	}
	
	@GetMapping("/session")
	public void m7(HttpSession session, String msg) { //msg 받아서 세션에 넣기
		//url : http://localhost:8080/myapp/session?msg=asdf
		System.out.println(msg); 
		session.setAttribute("msg", msg);
		//헤더에 담겨있는 Accept, Host 정보가 찍혀나옴
	}
}
