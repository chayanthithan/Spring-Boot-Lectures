package com.example.financeServiceDemo.controller;

import com.example.financeServiceDemo.model.RegisteredRequestModel;
import com.example.financeServiceDemo.model.RequestModel;
import com.example.financeServiceDemo.model.ResponseModel;
import com.example.financeServiceDemo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/financeService")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> registerUserDetails(@RequestBody RegisteredRequestModel registeredRequestModel){
        ResponseModel responseModel=new ResponseModel();
       boolean returnValues=userServiceImpl.saveRegisteredDetails(registeredRequestModel);
       if(returnValues){
           responseModel.setMessage("successfully registered !!");
           responseModel.setStatus("ok");
           return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
       }else{
           responseModel.setMessage("Unsuccessfully registered !!");
           responseModel.setStatus("ok");
           return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> loginUser(@RequestBody RequestModel requestModel){
        boolean getValue=userServiceImpl.loginUserById(requestModel);
        ResponseModel responseModel=new ResponseModel();
        if(getValue){
            responseModel.setStatus("ok");
            responseModel.setMessage("successfully login by "+requestModel.getUsername());
            return new ResponseEntity<>(responseModel,HttpStatus.CREATED);
        }else{
            responseModel.setStatus("ok");
            responseModel.setMessage("Unsuccessfully login by "+requestModel.getUsername());
            return new ResponseEntity<>(responseModel,HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}


