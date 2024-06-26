package com.sonchayan.StudentManagement.controller;

import com.sonchayan.StudentManagement.model.RequestModel;
import com.sonchayan.StudentManagement.model.ResponseModel;
import com.sonchayan.StudentManagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/student")
@Slf4j
public class LoginController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;
    @GetMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> checkLogingStudent(@RequestHeader(name = "Accept-Language",required = false) Locale locale,@RequestParam String studentEmail, @RequestParam String studentPassword){
       log.info("login controller has been reached");
        ResponseModel responseModel=new ResponseModel();
        log.debug(studentEmail+studentPassword);
      boolean getValue=studentService.checkStudent(studentEmail,studentPassword);

        if(getValue){

            responseModel.setMessage(resourceBundleMessageSource.getMessage("msg",null,locale)+studentEmail);
            responseModel.setStatus("ok");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }else{
            responseModel.setMessage(resourceBundleMessageSource.getMessage("msg",null,locale));
            responseModel.setStatus("ok");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }


    }
}
