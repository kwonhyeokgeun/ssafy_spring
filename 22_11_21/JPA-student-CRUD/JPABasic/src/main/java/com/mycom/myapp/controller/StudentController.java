package com.mycom.myapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.entity.Student;
import com.mycom.myapp.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/students")
    public Student insertStudent(@RequestBody Student student){
        return service.insertStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId){
        service.deleteStudent(studentId);
    }

    @GetMapping("/students/{studentId}")
    public Optional<Student> detailStudent(@PathVariable int studentId) {
        return service.detailStudent(studentId);
    }
    
    @GetMapping("/students")
    public List<Student> listStudent() {
        return service.listStudent();
    }
    
    @GetMapping("/students/count")
    public long countStudent() {
        return service.countStudent();
    }
    
    @GetMapping("/students/page")
    public List<Student> listStudent(int limit, int pageUnit) {
        return service.listStudent(limit, pageUnit);
    }
    
    @GetMapping("/students/studentnm")
    public List<Student> listStudent(String studentNm) {
        return service.findByStudentNm(studentNm);
    }
    
    //localhost:8080/students/emailandphone?email=5@gildong.com&phone=010-0000-0005
    @GetMapping("/students/emailandphone")
    public List<Student> findByEmailAndPhone(String email, String phone) { //둘다만족해야
        return service.findByEmailAndPhone(email, phone);
    }

    //localhost:8080/students/emailandphone?email=4@gildong.com&phone=010-0000-0005
    @GetMapping("/students/emailorphone")
    public List<Student> findByEmailOrPhone(String email, String phone) { //둘중하나만 맞아도
        return service.findByEmailOrPhone(email, phone);
    }
}