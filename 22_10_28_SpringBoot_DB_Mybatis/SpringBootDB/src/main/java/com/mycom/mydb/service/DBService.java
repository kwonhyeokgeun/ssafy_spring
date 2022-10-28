package com.mycom.mydb.service;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface DBService {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	int empInsert(EmpDto dto);
	int empDelete(int employeeId);
	int empChange(EmpDto dto);
}
