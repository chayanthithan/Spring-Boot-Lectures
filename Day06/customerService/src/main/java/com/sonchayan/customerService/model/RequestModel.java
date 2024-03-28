package com.sonchayan.customerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
    private Long customerId;
    private String customerName;
    private String customerPassword;

}
