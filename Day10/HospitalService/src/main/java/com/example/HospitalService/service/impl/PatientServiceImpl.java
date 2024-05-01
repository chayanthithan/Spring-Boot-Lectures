package com.example.HospitalService.service.impl;

import com.example.HospitalService.entity.Patient;
import com.example.HospitalService.exceptionHandler.CredentialNotMatchedException;
import com.example.HospitalService.exceptionHandler.NullPointerException;
import com.example.HospitalService.exceptionHandler.UserNotFoundException;
import com.example.HospitalService.model.RegisterModel;
import com.example.HospitalService.repository.PatientRepository;
import com.example.HospitalService.service.PatientService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public boolean registerPatientDetails(RegisterModel registerModel) throws Exception{
        Patient patient=new Patient();
        patient.setAdmittedDate(registerModel.getAdmittedDate());
        patient.setPatientEmail(registerModel.getPatientEmail());
        patient.setPatientAddress(registerModel.getPatientAddress());
        patient.setPatientName(registerModel.getPatientName());
        patient.setPatientMobile(registerModel.getPatientMobile());
        patient.setWardNo(registerModel.getWardNo());
        patient.setPatientPassword(registerModel.getPatientPassword());
        Optional<Patient> p= Optional.of(patientRepository.save(patient));
        if (p.isPresent()){
            return true;
        }else{
            throw new NullPointerException("nullpointer exception");
        }
    }

    @Override
    public boolean loginByPatient(String patientEmail, String patientPassword) throws Exception{
        Optional<Patient> patientObj= Optional.ofNullable(patientRepository.findBypatientEmail(patientEmail));
        if(patientObj.isPresent()){
            if(patientObj.get().getPatientPassword().equals(patientPassword))
                return true;
            else
                throw new CredentialNotMatchedException("credential Missed Matched");

        }else
            throw new UserNotFoundException("user not found");

    }

    @Override
    public List<Patient> searchPatient(RegisterModel registerModel) throws Exception{
        Patient patient=new Patient();
        patient.setPatientEmail(registerModel.getPatientEmail());
        patient.setPatientName(registerModel.getPatientName());
        patient.setPatientAddress(registerModel.getPatientAddress());
        patient.setPatientMobile(registerModel.getPatientMobile());
        patient.setPatientPassword(registerModel.getPatientPassword());
        patient.setWardNo(registerModel.getWardNo());
        patient.setAdmittedDate(registerModel.getAdmittedDate());

        ExampleMatcher exampleMatcher=ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example=Example.of(patient,exampleMatcher);
        List<Patient> listofpatient=patientRepository.findAll(example);
        if(listofpatient.isEmpty())
            throw new NullPointerException("null pointer exception");
        else
            return listofpatient;
    }
}
