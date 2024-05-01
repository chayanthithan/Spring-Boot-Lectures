package com.example.HospitalService.controller;

import com.example.HospitalService.entity.Patient;
import com.example.HospitalService.model.RegisterModel;
import com.example.HospitalService.model.ResponseModel;
import com.example.HospitalService.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospitalservice")
public class GetPatientDetailsController {
    @Autowired
    private PatientService patientService;
    @PostMapping(value = "/getpatients",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> getPatientDetails(@RequestBody RegisterModel registerModel) throws Exception{
        List<Patient> patient=patientService.searchPatient(registerModel);
        return patient;

    }
}
