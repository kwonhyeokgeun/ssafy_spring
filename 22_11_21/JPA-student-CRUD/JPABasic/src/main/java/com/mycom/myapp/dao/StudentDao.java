package com.mycom.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycom.myapp.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	
    List<Student> findByStudentNm(String studentNm);
    
    List<Student> findByEmailAndPhone(String email, String phone);
    List<Student> findByEmailOrPhone(String email, String phone);
}