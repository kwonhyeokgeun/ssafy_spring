package com.mycom.more;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycom.more.dto.StudentDto;
import com.mycom.more.service.StudentService;

@SpringBootTest
class SpringBootMore1ApplicationTests {

	@Autowired
	StudentService service;
	
	//StudentService 객체가 DI가 잘 되는지
	//StudentService를 이용해서 신규로 등록 1건 테스트
	
	@Test
	void testService() {
		assertNotNull(service); //null인지 따져본다는 뜻?
	}
	
	@Test
	void testInsert() {
		//프론트 개발 완료되지 않았을 때
		//insert process에 대한 테스트
		StudentDto dto = new StudentDto();
		dto.setStudentNm("박길동");
		dto.setEmail("park@gildong.com");
		dto.setPhone("010-0000-1111");
		assertEquals(1, service.insert(dto)); //같은 결과인지 알려줌  //실제로도 값이 db에 들어감
		
	}
	
	//#1. 아직 완료되지 않은 프론트에 종속적이지 않게 테스트를 진행
	//#2. Controller -> service -> dao 혹은 다른 레이어의 메소드 단위로 테스트 가능
	//#3. 레거시 시스템의 input/output 결과와 현재 신시스템의 input/output 개발 결과 비교/검증에 사용
	//#4. 독립적으로 @Transactional을 통해 tx 관리도 가능
}
