package com.example.HospitalService.controller;

import com.example.HospitalService.exceptionHandler.UserNotFoundException;
import com.example.HospitalService.model.ResponseModel;
import com.example.HospitalService.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/hospitalservice")
public class LoginController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;
    @GetMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> loginService(@RequestHeader(name = "Accept-Language",required = false) Locale locale, @RequestParam String patientEmail, @RequestParam String patientPassword) throws Exception{
        ResponseModel rm=new ResponseModel();
        boolean getResult=patientService.loginByPatient(patientEmail,patientPassword);
        if(getResult){
            rm.setStatus("OK");
            rm.setMessage(resourceBundleMessageSource.getMessage("key",null,locale)+patientEmail);
            return new ResponseEntity<>(rm, HttpStatus.CREATED);
        }else{
            throw new UserNotFoundException("user not found exception");
        }
    }
}
