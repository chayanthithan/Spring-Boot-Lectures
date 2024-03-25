package com.sonchayan.financeService.controller;

import com.sonchayan.financeService.model.RegisterRequestModel;
import com.sonchayan.financeService.model.RequestModel;
import com.sonchayan.financeService.model.ResponseModel;
import com.sonchayan.financeService.service.RegisterService;
import com.sonchayan.financeService.service.impl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financeService")
public class RegisterFinanceController {
    @Autowired
    private RegisterService registerService;
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> saveRegisteredUser(@RequestBody RegisterRequestModel registerRequestModel){
        ResponseModel responseModel=new ResponseModel();
        registerService.saveRegisteredUserDetails(registerRequestModel);
        responseModel.setMessage("successfully registered!!");
        responseModel.setStatus("created");
        return new ResponseEntity<>(responseModel,HttpStatus.CREATED);

    }
}
