package com.example.loginService.controller;

import com.example.loginService.entity.User;
import com.example.loginService.model.RequestModel;
import com.example.loginService.model.ResponseModel;
import com.example.loginService.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {
    //Autowired service
    @Autowired
    private UserServiceimpl userServiceimpl;
    @GetMapping(value = "login",produces = MediaType.APPLICATION_JSON_VALUE)
    public String userLogin(@RequestParam String userName, @RequestParam String userPassword){
        ResponseModel responseModel=new ResponseModel();
        responseModel.setMessage("success");
        responseModel.setStatus("ok");
//        return new ResponseEntity<>(responseModel,HttpStatus.OK);
        return "successfuly logged";
    }

    //register controller
    @PostMapping(value = "register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> userRegister(@RequestBody RequestModel requestModel){
        ResponseModel responseModel=new ResponseModel();
        boolean getResult=userServiceimpl.registerUserDetails(requestModel);
        if(getResult){
            responseModel.setMessage("registered successfully");
            responseModel.setStatus("OK");
            return new ResponseEntity<>(responseModel,HttpStatus.OK);
        }else{
            responseModel.setMessage("registered Unsuccessfully");
            responseModel.setStatus("OK");
            return new ResponseEntity<>(responseModel,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
