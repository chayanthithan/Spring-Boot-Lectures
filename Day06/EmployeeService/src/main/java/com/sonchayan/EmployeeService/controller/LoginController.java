package com.sonchayan.EmployeeService.controller;

import com.sonchayan.EmployeeService.model.RequestModel;
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
@RequestMapping("employeeService")
public class LoginController {
    @Autowired
    private EmployeeServiceImpl employeeServiceimpl;
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> loginEmployee(@RequestBody RequestModel requestModel) throws Exception{
        boolean getResult=employeeServiceimpl.loginEmployeeService(requestModel);
        ResponseModel rm=new ResponseModel();
        if(getResult){
            rm.setStatus("ok");
            rm.setMessage("successfully logined by "+requestModel.getEmpName());
            return new ResponseEntity<>(rm, HttpStatus.OK);
        }else{
            rm.setStatus("ok");
            rm.setMessage("Unsuccessfully logined ");
            return new ResponseEntity<>(rm, HttpStatus.OK);
        }
    }
}
