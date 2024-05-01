package com.example.HospitalService.service;

import com.example.HospitalService.entity.Patient;
import com.example.HospitalService.model.RegisterModel;

import java.util.List;

public interface PatientService {
    public boolean registerPatientDetails(RegisterModel registerModel) throws Exception;

    boolean loginByPatient(String patientEmail, String patientPassword) throws Exception;

    List<Patient> searchPatient(RegisterModel registerModel) throws Exception;
}
