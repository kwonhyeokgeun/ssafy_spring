package com.mycom.rest.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.rest.dto.StudentDto;



@Mapper
public interface StudentDao {
	int studentInsert(StudentDto dto);
}
