package com.sonchayan.loginAndlogout.controller;

import com.sonchayan.loginAndlogout.model.ForgetPassword;
import com.sonchayan.loginAndlogout.model.ResponseForgetPassword;
import com.sonchayan.loginAndlogout.model.ResponseRegister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginandLogout")
public class ForgetPasswordController {

//http://localhost:8080/loginandLogout/forgetPassword?email=chayan@gmail.com
    @GetMapping(value = "forgetPassword",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseForgetPassword> logicForgetPassword(@RequestParam String email){
        ResponseForgetPassword responseForgetPassword=new ResponseForgetPassword();
        responseForgetPassword.setMessage("reset password");
        responseForgetPassword.setEmail(email);
        responseForgetPassword.setStatus("ok");

        return new ResponseEntity<>(responseForgetPassword, HttpStatus.OK);


    }
}
