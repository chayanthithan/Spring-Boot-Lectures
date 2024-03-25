package com.sonchayan.financeService.Controller;

import com.sonchayan.financeService.Model.RegisterUserModel;
import com.sonchayan.financeService.Model.RequestModel;
import com.sonchayan.financeService.Model.ResponseModel;
import com.sonchayan.financeService.Service.Impl.RegisterServiceImpl;
import com.sonchayan.financeService.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {
    @Autowired
    private RegisterServiceImpl registerServiceImpl;
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> userLogin(@RequestBody RequestModel requestModel){
        ResponseModel responseModel=new ResponseModel();
        responseModel.setMessage("successfully logined by "+requestModel.getUsername());
        responseModel.setResult("ok");
        return  new ResponseEntity<>(responseModel, HttpStatus.OK);

    }
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> userRegister(@RequestBody RegisterUserModel registerUserModel){

       Boolean accCreated= registerServiceImpl.createRegisterUser(registerUserModel);
       ResponseModel responseModel=new ResponseModel();
        if(accCreated) {
            responseModel.setMessage("registered successfully");
            responseModel.setResult("Created");
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        }
        else {

            responseModel.setMessage("registered successfully");
            responseModel.setResult("Created");
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        }
    }
}
