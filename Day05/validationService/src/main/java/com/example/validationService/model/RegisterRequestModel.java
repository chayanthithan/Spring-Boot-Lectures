package com.example.validationService.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModel {
    private String student_name;
    private String course_name;
    private String department_name;
    private String faculty_name;
    private String email;
    private String password;
}
