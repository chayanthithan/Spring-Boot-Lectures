package com.sonchayan.StudentManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
    private String studentName;
    private String studentRollNum;
    private String studentAddress;
    private String studentEmail;
    private String studentPassword;
}
