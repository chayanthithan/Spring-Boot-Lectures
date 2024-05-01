package com.example.loginService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_details")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_Id")
    private Long studentid;
    @Column(name = "student_Name")
    private String studentName;
    @Column(name = "student_Email")
    private String studentEmail;
    @Column(name = "student_Address")
    private String studentAddress;
    @Column(name = "student_Password")
    private String studentPassword;
}
