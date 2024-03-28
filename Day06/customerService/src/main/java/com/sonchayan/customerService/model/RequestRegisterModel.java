package com.sonchayan.customerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestRegisterModel {
    private String customerName;
    private String customerPassword;
    private String customerEmail;
    private String customerAddress;
    private String customerMobile;
}
