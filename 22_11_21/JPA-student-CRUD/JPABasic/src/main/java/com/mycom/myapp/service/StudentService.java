package com.mycom.myapp.service;

import java.util.List;
import java.util.Optional;

import com.mycom.myapp.entity.Student;

public interface StudentService {
	public Student insertStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteStudent(int studentId);    
	public Optional<Student> detailStudent(int studentId);
	
	public List<Student> listStudent();
	public Long countStudent();
	
	public List<Student> listStudent(int limit, int pageNum);
	
	public List<Student> findByStudentNm(String studentNm);
	
	public List<Student> findByEmailAndPhone(String email, String phone);
    public List<Student> findByEmailOrPhone(String email, String phone);
}
