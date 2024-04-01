package com.sonchayan.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserModel {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
}
