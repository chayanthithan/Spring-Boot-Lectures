package com.example.loginService.service.impl;

import com.example.loginService.entity.Student;
import com.example.loginService.repository.StudentRepository;
import com.example.loginService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    public Boolean registerStudentDetails(Student student) {
        Student stu=new Student();
        stu.setStudentName(student.getStudentName());
        stu.setStudentEmail(student.getStudentEmail());
        stu.setStudentAddress(student.getStudentAddress());
        stu.setStudentPassword(student.getStudentPassword());
        Optional<Student> getResult= Optional.of(repository.save(stu));
        if(getResult.isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
