package com.example.demoResponseAndRequest.controller;

import com.example.demoResponseAndRequest.model.RequestModel;
import com.example.demoResponseAndRequest.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financeService")
public class financeServiceController {
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> loginService(@RequestBody RequestModel requestModel){
        ResponseModel responseModel=new ResponseModel();
        responseModel.setMessage("successfully logined by "+requestModel.getUsername());
        responseModel.setStatus("ok");
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}
