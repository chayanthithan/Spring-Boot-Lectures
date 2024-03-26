package com.example.validationService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_details")
public class RegisterStudentEntity {

//    @Pattern(regexp = "2018ICTS[0-9]{2}")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    @NotNull
//    @Pattern(regexp = "2018ICTS[0-9]{2}")
    private Long student_id;
    @Column(name = "student_name")
    @Size(min = 1,max = 25)
    private String student_name;
    @Column(name = "course_name")
    @Size(min = 1,max = 25)
    private String course_name;
    @Column(name = "department_name")
    @Size(min = 5,max = 35)
    private String department_name;
    @Column(name = "faculty_name")
    @Size(min = 5,max = 50)
    private String faculty_name;
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "password")
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
    private String password;


}
