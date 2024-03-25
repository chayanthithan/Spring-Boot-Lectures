package com.sonchayan.financeService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestModel {
    private String fname;
    private String lname;
    private String email;
    private String address;
    private String mobile;
    private String password;
    private String con_password;

}
