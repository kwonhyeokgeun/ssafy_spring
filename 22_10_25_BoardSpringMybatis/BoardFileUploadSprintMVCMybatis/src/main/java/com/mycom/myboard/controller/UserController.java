package com.mycom.myboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.dto.UserResultDto;
import com.mycom.myboard.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	private final int SUCCESS = 1;
	private final int FAIL = -1;
	
	
	@PostMapping(value="/register")
	public ResponseEntity<Map<String, String>> register(UserDto dto){
		System.out.println("register");
		System.out.println(dto);
		UserResultDto userResultDto = userService.userRegister(dto);
		
		Map<String,String> map = new HashMap<>();
		if(userResultDto.getResult() ==SUCCESS) { //등록 성공
			map.put("result", "success");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
		}else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.NOT_FOUND);
		}

	}
}
