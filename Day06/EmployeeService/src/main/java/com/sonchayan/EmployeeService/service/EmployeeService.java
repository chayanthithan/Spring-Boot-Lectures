package com.sonchayan.EmployeeService.service;

import com.sonchayan.EmployeeService.entity.Employee;
import com.sonchayan.EmployeeService.model.RequestModel;
import com.sonchayan.EmployeeService.model.RequestRegisterModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    boolean saveEmployeeDetails(RequestRegisterModel requestRegisterModel);

    boolean loginEmployeeService(RequestModel requestModel) throws Exception;

    Optional<Employee> getEmployeeById(Long id) throws Exception;

    List<Employee> getMatchedEmployee(RequestRegisterModel requestRegisterModel);
}
