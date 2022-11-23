package com.mycom.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.StudentDao;
import com.mycom.myapp.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;
	
	@Override
	public Student insertStudent(Student student) {
	    return dao.save(student);
	}
	
	@Override
	public Student updateStudent(Student student) {
	    return dao.save(student);
	}
	
	@Override
	public void deleteStudent(int studentId) {
	    dao.deleteById(studentId);
	}
	
	@Override
	public Optional<Student> detailStudent(int studentId) {
	    return dao.findById(studentId);
	}
	
	@Override
	public List<Student> listStudent() {
		return dao.findAll();
	}

	@Override
	public Long countStudent() {
		return dao.count();
	}

	@Override
	public List<Student> listStudent(int limit, int pageNum) {
		Pageable pageable = PageRequest.of(pageNum, limit);
		Page<Student> page = dao.findAll(pageable);
		return page.toList();
		
	}

	@Override
	public List<Student> findByStudentNm(String studentNm) {
		return dao.findByStudentNm(studentNm);
	}
	
	@Override
	public List<Student> findByEmailAndPhone(String email, String phone) {
	    return dao.findByEmailAndPhone(email, phone);
	}

	@Override
	public List<Student> findByEmailOrPhone(String email, String phone) {
	    return dao.findByEmailOrPhone(email, phone);
	}
}