package com.sonchayan.EmployeeService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRegisterModel {

    //camel case issue  we should follow camel case otherwise it will generate an error
    private String empName;
    private String empAddress;
    private String empPhoneNumber;
    private String empEmail;
    private String empPassword;


}
