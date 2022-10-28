package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.DBService;

@RestController
public class DBController {
	
	@Autowired
	DBService service;

	@GetMapping(value="/empDetail/{employeeId}")

	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto dto = service.empDetail(employeeId);
		System.out.println(dto);
		return dto;
	}
	
	@GetMapping(value="/empList")
	public List<EmpDto> empList() {
		System.out.println("empList");
		List<EmpDto> dtoList = service.empList();
		System.out.println(dtoList);
		return dtoList;
	}
	
	@PostMapping(value="/empInsert")
	public int empInsert(EmpDto empDto) { 
		System.out.println(empDto);
		int ret = service.empInsert(empDto);
		return ret;
	}
	
	
	@PostMapping(value="/empDelete")
	public int empDelete(int employeeId) { 
		System.out.println(employeeId);
		int ret = service.empDelete(employeeId);
		return ret;
	}
	
	@PostMapping(value="/empChange")
	public int empChange(EmpDto empDto) { 
		System.out.println(empDto);
		int ret = service.empChange(empDto);
		return ret;
	}
	
}
