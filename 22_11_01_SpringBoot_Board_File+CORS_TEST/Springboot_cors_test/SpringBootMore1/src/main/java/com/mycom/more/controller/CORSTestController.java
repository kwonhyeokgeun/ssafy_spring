package com.mycom.more.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//axios library에서 http 요청을 보낼 때 credentials 설정(true : 기존 세션 유지/ false : 항상 새로운 sessionid 전송)
//이후 vue-cli로 개발시 백엔드는 아래와 같이 origins = vue-cli 개발 서버 정보를, allowCredentials = "true"로 설정해야
//sessionid가 지속되고 이를 통해서 로그인 등 서버세션을 사용할 수 있다.
//서버세션을 사용하지 않을려면 jwt등 별도의 state 저장수단을 이용해야함, 그럴경우 위 설정 필요x
@CrossOrigin( //cors 설정
		origins="http://127.0.0.1:5500", //VS코드로 들어갔을 때 포트
		allowCredentials = "true", //sessionid 기존처럼 고정 -> server session 계속 사용
		allowedHeaders="*",
		methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,  //이것들 허용해 주는듯
				RequestMethod.OPTIONS, RequestMethod.HEAD
		}
)

@RestController
public class CORSTestController {
	@GetMapping("/getcors")
	public ResponseEntity<Map<String, String>> getCORS(String param){
		System.out.println("getcors "+ param);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
		
	}
	
	@PostMapping("/postcors")
	public ResponseEntity<Map<String, String>> postCORS(String param){
		System.out.println("postcors "+ param);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
		
	}
	
	@PutMapping("/putcors/{num}")
	public ResponseEntity<Map<String, String>> putCORS(@PathVariable int num){
		System.out.println("putcors "+ num);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletecors/{num}")
	public ResponseEntity<Map<String, String>> deleteCORS(@PathVariable int num){
		System.out.println("deletecors "+ num);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
		
	}
}
