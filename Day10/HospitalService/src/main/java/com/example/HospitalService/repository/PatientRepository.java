package com.example.HospitalService.repository;

import com.example.HospitalService.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findBypatientEmail(String patientEmail);
}
