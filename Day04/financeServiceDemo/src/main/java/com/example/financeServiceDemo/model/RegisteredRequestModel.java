package com.example.financeServiceDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredRequestModel {
    private String fname;
    private String lname;
    private String email;
    private String address;
    private String mobile;
    private String password;
    private String con_password;

}
