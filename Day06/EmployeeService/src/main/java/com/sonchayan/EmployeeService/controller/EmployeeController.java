package com.sonchayan.EmployeeService.controller;

import com.sonchayan.EmployeeService.entity.Employee;
import com.sonchayan.EmployeeService.model.RequestRegisterModel;
import com.sonchayan.EmployeeService.model.ResponseModel;
import com.sonchayan.EmployeeService.service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employeeService")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceimpl;
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) throws Exception{
        ResponseModel responseModel=new ResponseModel();
        Optional<Employee> emp=employeeServiceimpl.getEmployeeById(id);
        Employee employee=emp.get();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    //as per in this @Requestbody Annotation RequestRegisterModel does not have
    // any validation if it is we have to create another responsemodel witjout validation based on our need
    @PostMapping("/fetchEmployee")
    public List<Employee> fetchMatchedEmployee(@RequestBody RequestRegisterModel requestRegisterModel){
        Employee employee=new Employee();
      List<Employee> employeeList=employeeServiceimpl.getMatchedEmployee(requestRegisterModel);
        return employeeList;
    }
}
