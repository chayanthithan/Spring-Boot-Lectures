package com.example.HospitalService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient_details")
public class Patient {
    //pojo class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_ID")
    private Long patientID;
    @Column(name = "patient_Name")
    @Size(min = 2)
    private String patientName;
    @Column(name = "patient_Email")
    @Email
    private String patientEmail;
    @Column(name = "patient_Address")
    private String patientAddress;
    @Column(name = "patient_Mobile")
    @Size(min = 10,max = 10)
    private String patientMobile;
    @Column(name = "patient_Password")
    private String patientPassword;
    @Column(name = "ward_No")
    @Size(min = 1)
    private String wardNo;
    @Column(name = "admitted_Date")
    private String admittedDate;
}
