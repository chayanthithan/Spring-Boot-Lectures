package com.sonchayan.loginAndlogout.controller;

import com.sonchayan.loginAndlogout.model.Register;
import com.sonchayan.loginAndlogout.model.ResponseRegister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginandLogout")
public class RegisterController {
//    http://localhost:8080/loginandLogout/register
//    {
//        "firstName":"siva",
//            "lastName":"kumar",
//            "mobile":"0763244160",
//            "address":"kilinochci",
//            "email":"kumarchayan@gmail.com"
//    }
    @PostMapping(value = "register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseRegister> postRegister(@RequestBody Register register){
        ResponseRegister responseRegister=new ResponseRegister();
        responseRegister.setFirstname(register.getFirstName());
        responseRegister.setLastname(register.getLastName());
        responseRegister.setMessage("registration is successful");
        responseRegister.setStatus("created");
        return new ResponseEntity<>(responseRegister, HttpStatus.CREATED);

    }
}
