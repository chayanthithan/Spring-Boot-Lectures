package com.sonchayan.EmployeeService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee_Data")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long emp_id;
    @Column(name = "emp_name")
    private String emp_name;
    @Column(name = "emp_address")
    private String emp_address;
    @Column(name = "emp_phoneNumber")
    private String emp_phoneNumber;
    @Column(name = "emp_email")
    private String emp_email;
    @Column(name = "emp_password")
    private String emp_password;
}
