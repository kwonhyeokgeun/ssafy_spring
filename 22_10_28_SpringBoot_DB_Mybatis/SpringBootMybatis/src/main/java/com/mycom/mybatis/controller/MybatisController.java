package com.mycom.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MybatisService;

@RestController
public class MybatisController {
	
	@Autowired
	MybatisService service;
	
	@GetMapping(value="/empDetail/{employeeId}")
	public EmpDto empDetail(@PathVariable int employeeId) {		
		System.out.println(employeeId);
		EmpDto dto = service.empDetail(employeeId);
		return dto;
	}
	
	@GetMapping(value="/empList")
	public List<EmpDto> empList(){
		List<EmpDto> empList = service.empList();
		return empList;
	}
	
	@PostMapping(value="/empInsert")
	public int empInsert(EmpDto empDto) {		// FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(empDto);		
		int ret = service.empInsert(empDto);
		return ret;
	}
	
	@PostMapping(value="/empUpdate")
	public int empUpdate(EmpDto empDto) {		// FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(empDto);		
		int ret = service.empUpdate(empDto);
		return ret;
	}
	
	@PostMapping("/empDelete")
	public int empDelete(int employeeId) {		// FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(employeeId);		
		int ret = service.empDelete(employeeId);
		return ret;
	}
	
	
	@GetMapping("/empListParameterMap")
	public List<EmpDto> empListParameterMap(String firstName, String lastName) {		
		System.out.println("empListParameterMap");
		Map<String, String> map= new HashMap<String, String>();
		map.put("firstName",firstName);
		map.put("lastName",lastName);
		
		
		List<EmpDto> ret = service.empListParameterMap(map);
		return ret;
	}
	
	@GetMapping("/empListParameterMap2")
	public List<EmpDto> empListParameterMap2(String firstName, String lastName) {		
		System.out.println("empListParameterMap2");
		
		List<EmpDto> ret = service.empListParameterMap2(firstName, lastName);
		return ret;
	}
	
	@GetMapping("/empListParameterMap3")
	public List<EmpDto> empListParameterMap3(EmpDto empDto) {
		System.out.println("empListParameterMap3");
		
		List<EmpDto> ret = service.empListParameterMap3(empDto);
		return ret;
	}
	
	@GetMapping("/empListLike")
	public List<EmpDto> empListLike(String firstName) {
		System.out.println("empListLike");
		List<EmpDto> ret = service.empListLike(firstName);
		return ret;
	}
}
