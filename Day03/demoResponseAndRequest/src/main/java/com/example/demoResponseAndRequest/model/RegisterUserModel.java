package com.example.demoResponseAndRequest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserModel {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String con_password;
    private String address;
    private String mobile;

}
