package com.example.HospitalService.controller;

import com.example.HospitalService.exceptionHandler.NullPointerException;
import com.example.HospitalService.exceptionHandler.UserNotFoundException;
import com.example.HospitalService.model.RegisterModel;
import com.example.HospitalService.model.RequestModel;
import com.example.HospitalService.model.ResponseModel;
import com.example.HospitalService.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospitalservice")
public class RegisterController {
    @Autowired
    private PatientService patientService;
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> registerPatient(@RequestBody RegisterModel registerModel) throws Exception{
        ResponseModel rm=new ResponseModel();
        boolean getResult=patientService.registerPatientDetails(registerModel);
        if(getResult){
            rm.setMessage("registration done ");
            rm.setStatus("Ok");
            return new ResponseEntity<>(rm, HttpStatus.CREATED);
        }else{
           throw new NullPointerException("Null pointer exception");
        }
    }
}
