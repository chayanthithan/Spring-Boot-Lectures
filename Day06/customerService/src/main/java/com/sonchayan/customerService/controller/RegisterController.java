package com.sonchayan.customerService.controller;

import com.sonchayan.customerService.model.RequestModel;
import com.sonchayan.customerService.model.RequestRegisterModel;
import com.sonchayan.customerService.model.ResponseModel;
import com.sonchayan.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerservice")
public class RegisterController {
    @Autowired
    private CustomerService customerService;
@PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> registerCustomer(@RequestBody RequestRegisterModel requestRegisterModel){
        ResponseModel responseModel=new ResponseModel();
        boolean getResult=customerService.saveCustomerDetails(requestRegisterModel);
        if(getResult){
            responseModel.setMessage("successfully registered!!!!");
            responseModel.setStatus("OK");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }else{
            responseModel.setMessage("Unsuccessfully registered!!!!");
            responseModel.setStatus("OK");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }



    }
}
