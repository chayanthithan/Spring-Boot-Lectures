package com.example.validationService.controller;

import com.example.validationService.ExceptionHandler.NullPointerException;
import com.example.validationService.ExceptionHandler.UserNotFoundException;
import com.example.validationService.model.RegisterRequestModel;
import com.example.validationService.model.RequestModel;
import com.example.validationService.model.ResponseModel;
import com.example.validationService.service.ServiceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@interface MyAnno{
//    String name();  //these value should give when use annotation
//    String message();
//    String value() default "unexpected error 1000";
//}
//@MyAnno(name = "hfhf",message = "jdhfhfj")-------->custom annotation
@RestController
@RequestMapping("/validationService")
public class StudentController{
    @Autowired
    private StudentServiceImpl studentServiceImpl;
//login
@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ResponseModel> loginStudent(@RequestBody RequestModel requestModel) throws Exception{
    ResponseModel responseModel=new ResponseModel();
//    try{
//        boolean getResult=studentServiceImpl.findLogedStudent(requestModel);
//        responseModel.setMessage("successfully logged "+requestModel.getStudent_name()+" details");
//        responseModel.setStatus("ok");
//    }catch(UserNotFoundException exception){
//        System.out.println(exception);
//    }catch(NullPointerException ex){
//        System.out.println(ex);
//    }catch(Exception e){
//        System.out.println(e);
//    }

    responseModel.setMessage("successfully logged "+requestModel.getStudent_name()+" details");
    responseModel.setStatus("ok");
//    studentServiceImpl.loginUser();

    studentServiceImpl.findLogedStudent(requestModel);



    return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
//        if(getResult){
//            responseModel.setMessage("successfully logged "+requestModel.getStudent_name()+" details");
//            responseModel.setStatus("ok");
//            return new ResponseEntity<>(responseModel, HttpStatus.OK);
//        }else{
//            responseModel.setMessage("Unsuccessfully logged ");
//            responseModel.setStatus("ok");
//            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }

//register
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> registerStudent(@RequestBody @Validated RegisterRequestModel registerRequestModel){
     ResponseModel responseModel=new ResponseModel();
       boolean getValue= studentServiceImpl.saveStudentDetails(registerRequestModel);
       if(getValue){
           responseModel.setMessage("successfully registered "+registerRequestModel.getStudent_name()+" details");
           responseModel.setStatus("ok");
           return new ResponseEntity<>(responseModel, HttpStatus.OK);
       }else{
           responseModel.setMessage("Unsuccessfully registered ");
           responseModel.setStatus("ok");
           return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

}
