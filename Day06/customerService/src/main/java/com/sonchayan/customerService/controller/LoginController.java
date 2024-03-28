package com.sonchayan.customerService.controller;

import com.sonchayan.customerService.model.RequestModel;
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
public class LoginController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> loginCustomer(@RequestBody RequestModel requestModel) throws Exception{
        ResponseModel responseModel=new ResponseModel();

        responseModel.setStatus("ok");
           responseModel.setMessage("successfully logged by "+requestModel.getCustomerName());
        customerService.loginCustomerData(requestModel);
           return  new ResponseEntity<>(responseModel, HttpStatus.OK);

//       if(getResult){
//           responseModel.setStatus("ok");
//           responseModel.setMessage("successfully logged by "+requestModel.getCustomerName());
//           return  new ResponseEntity<>(responseModel, HttpStatus.OK);
//       }else{
//           responseModel.setStatus("ok");
//           responseModel.setMessage("Unsuccessfully logged by "+requestModel.getCustomerName());
//           return  new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
//       }

    }

}
