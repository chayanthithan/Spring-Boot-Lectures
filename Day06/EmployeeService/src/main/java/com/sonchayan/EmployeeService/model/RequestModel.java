package com.sonchayan.EmployeeService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestModel {
    private Long empId;
    private String empName;
    private String empPassword;
}
