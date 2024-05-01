package com.sonchayan.StudentManagement.controller;

import com.sonchayan.StudentManagement.model.RequestModel;
import com.sonchayan.StudentManagement.model.ResponseModel;
import com.sonchayan.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class RegisterController {
    //student service variable
    @Autowired
    private StudentService studentService;
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> registerStudentData(@RequestBody RequestModel requestModel){
        ResponseModel responseModel=new ResponseModel();
        boolean getResult=studentService.storeRegisteredStudentsDetails(requestModel);
        if(getResult){
            responseModel.setMessage("successfully registered");
            responseModel.setStatus("ok");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }else{
            responseModel.setMessage("something went to wrong to register student");
            responseModel.setStatus("ok");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }

    }
}
