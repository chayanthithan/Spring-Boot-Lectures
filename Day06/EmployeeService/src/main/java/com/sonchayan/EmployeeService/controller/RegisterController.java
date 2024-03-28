package com.sonchayan.EmployeeService.controller;

import com.sonchayan.EmployeeService.model.RequestRegisterModel;
import com.sonchayan.EmployeeService.model.ResponseModel;
import com.sonchayan.EmployeeService.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeeService")
public class RegisterController {
    @Autowired
    private EmployeeServiceImpl employeeServiceimpl;

    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ResponseModel> saveEmployeeDetails(@RequestBody RequestRegisterModel requestRegisterModel){
        ResponseModel responseModel=new ResponseModel();
       boolean getValue= employeeServiceimpl.saveEmployeeDetails(requestRegisterModel);
       if(getValue){
           responseModel.setMessage("successfully registered !!!");
           responseModel.setStatus("OK");
           return new ResponseEntity<>(responseModel, HttpStatus.OK);
       }else{
           responseModel.setMessage("Unsuccessfully registered !!!");
           responseModel.setStatus("OK");
           return new ResponseEntity<>(responseModel, HttpStatus.OK);
       }
    }
@PostMapping(value = "/store",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> storeEmployeeDetails(@RequestBody RequestRegisterModel requestRegisterModel){
        return new ResponseEntity<>(new ResponseModel(),HttpStatus.OK);
    }
}
