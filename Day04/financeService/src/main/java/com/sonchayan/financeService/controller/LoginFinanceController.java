package com.sonchayan.financeService.controller;

import com.sonchayan.financeService.model.RequestModel;
import com.sonchayan.financeService.model.ResponseModel;
import com.sonchayan.financeService.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/financeService")
public class LoginFinanceController {
    @Autowired
    private LoginService loginService;
    @GetMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> loginServiceLogic(@RequestParam("user_id") Long user_id,@RequestParam("password") String password,@RequestParam("username") String username){
        ResponseModel responseModel=new ResponseModel();
        Boolean getresult=loginService.findUserDetails(user_id,password);
        if(getresult){
            responseModel.setMessage("Successfully logined");
            responseModel.setStatus("ok");
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        }else{
            responseModel.setMessage("Unsuccessfully logined");
            responseModel.setStatus("error");
            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResponseModel> loginServiceLogic(@RequestBody RequestModel requestModel){
//        ResponseModel responseModel=new ResponseModel();
//        Boolean getresult=loginService.findUserDetails(requestModel);
//        if(getresult){
//            responseModel.setMessage("Successfully logined");
//            responseModel.setStatus("ok");
//            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
//        }else{
//            responseModel.setMessage("Unsuccessfully logined");
//            responseModel.setStatus("error");
//            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
