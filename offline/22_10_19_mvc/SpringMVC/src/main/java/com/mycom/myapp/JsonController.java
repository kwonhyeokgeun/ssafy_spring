package com.mycom.myapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class JsonController {
	
	@PostMapping(value="/emp")
	public void m1(@RequestBody EmpDto dto ) { //json 객체를 바로 dto에 넣어줌
		System.out.println(dto);
	}
	
	@PostMapping(value="/empList")
	public void m2(@RequestBody List<EmpDto> dtoList ) {
		System.out.println("empList");
		for(EmpDto dto : dtoList) {
			System.out.println(dto);
		}
	}
	
	
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto m3(@PathVariable int employeeId) {
		System.out.println(employeeId);
		//employeeId에 맞는 empDto 객체를 만들어서 json으로 response
		EmpDto empDto  = new EmpDto(2000,"길동4","홍4","hong4@gindong.com","2022-10-19");
		return empDto;
	}
	
	@GetMapping(value="/empDetailList")
	@ResponseBody
	public List<EmpDto> m4() {
		System.out.println("empDetailList");
		//empDto 객체 리스트를 만들어서 json으로 전송
		List<EmpDto> empList=new ArrayList<>();
		empList.add(new EmpDto(2000,"길동4","홍4","hong4@gindong.com","2022-10-19"));
		empList.add(new EmpDto(2000,"길동5","홍5","hong5@gindong.com","2022-10-19"));
		return empList;
	}
	
	@GetMapping(value="/localDateTime")
	@ResponseBody
	public LocalDateTime m5() {
		return LocalDateTime.now();
	}

}
