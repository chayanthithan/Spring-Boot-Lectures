package com.sonchayan.StudentManagement.service.impl;

import com.sonchayan.StudentManagement.entity.Student;
import com.sonchayan.StudentManagement.model.RequestModel;
import com.sonchayan.StudentManagement.repository.StudentRepository;
import com.sonchayan.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public Boolean storeRegisteredStudentsDetails(RequestModel requestModel) {
        Student stu=new Student();
        stu.setStudentName(requestModel.getStudentName());
        stu.setStudentRollNum(requestModel.getStudentRollNum());
        stu.setStudentEmail(requestModel.getStudentEmail());
        stu.setStudentAddress(requestModel.getStudentAddress());
        stu.setStudentPassword(requestModel.getStudentPassword());
        Student stuObj=studentRepo.save(stu);
//        if(stuObj.getStudentName().isEmpty())
//            return false;
//        else
//            return true;
        return !stuObj.getStudentName().isEmpty();
    }

    @Override
    public boolean checkStudent(String studentEmail, String studentPassword) {
        Student stu=new Student();
        Student fetchedStu=studentRepo.findBystudentEmail(studentEmail);
        return fetchedStu.getStudentPassword().equals(studentPassword);

    }
}
