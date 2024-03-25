package com.sonchayan.financeService.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserModel {
    private String fname;
    private String lname;
    private String password;
    private String email;
    private String address;
    private String mobile;
}
