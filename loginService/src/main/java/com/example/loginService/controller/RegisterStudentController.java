package com.example.loginService.controller;

import com.example.loginService.entity.Student;
import com.example.loginService.model.RequestModel;
import com.example.loginService.model.ResponseModel;
import com.example.loginService.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins="http://localhost:4200")
public class RegisterStudentController {
    @Autowired
    private StudentServiceImpl studentService;
    //,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE
    @PostMapping(value = "/register")
    public ResponseEntity<ResponseModel> registerStudent(@RequestBody Student student){
        ResponseModel rm=new ResponseModel();
        boolean getValue=studentService.registerStudentDetails(student);
        if(getValue){
            rm.setMessage("successfully logged");
            rm.setStatus("OK");
            return new ResponseEntity<>(rm, HttpStatus.OK);
        }else{
            rm.setMessage("Unsuccessfully");
            rm.setStatus("OK");
            return new ResponseEntity<>(rm, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
