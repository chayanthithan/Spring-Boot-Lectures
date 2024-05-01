package com.sonchayan.UserService.controller;

import com.sonchayan.UserService.model.RegisterUserModel;
import com.sonchayan.UserService.model.ResponseModel;
import com.sonchayan.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userservice")
public class RegisterController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> adduser(@RequestBody RegisterUserModel rum){
        ResponseModel responseModel=new ResponseModel();
        boolean getResult=userService.addUserData(rum);
        if(getResult){
            responseModel.setMessage("successfully registered!!!");
            responseModel.setStatus("OK");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }else{
            responseModel.setMessage("Unsuccessfully registered!!!");
            responseModel.setStatus("OK");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }


    }
}
