package com.sonchayan.StudentManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_data")
public class Student {
    //this is the pojo class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_Id")
    @NotNull
    private Long studentId;

    @Column(name = "student_Name")
    @NotNull
    private String studentName;
    @Column(name = "student_RollNum")
    private String studentRollNum;
    @Column(name = "student_Address")
    private String studentAddress;
    @Column(name = "student_Email")
    @Email
    private String studentEmail;
    @Column(name = "student_Password")
    private String studentPassword;
}
