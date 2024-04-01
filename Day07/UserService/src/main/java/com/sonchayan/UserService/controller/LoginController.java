package com.sonchayan.UserService.controller;

import com.sonchayan.UserService.entity.UserEntity;
import com.sonchayan.UserService.exceptionHandler.UserNotFoundException;
import com.sonchayan.UserService.model.RequestModel;
import com.sonchayan.UserService.model.ResponseModel;
import com.sonchayan.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userservice")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> userLogin(@RequestBody RequestModel requestModel) throws Exception{
        ResponseModel rm=new ResponseModel();
       Boolean getResult=userService.userToLogin(requestModel);
       if(getResult){
           rm.setStatus("ok");
           rm.setMessage("successfully logged");
           return new ResponseEntity<>(rm, HttpStatus.OK);

       }else{
           throw new UserNotFoundException("UserNot found");
       }

    }
    //i want to fetch user details by name
    //i could not return multiple reults
    @GetMapping(value = "/find/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEntity> getUserUsingPassword(@PathVariable("userName") String userName) throws Exception{
        List<UserEntity> ue=userService.findUsersByName(userName);
        return ue;

    }
}
