package com.sonchayan.EmployeeService.service.Impl;

import com.sonchayan.EmployeeService.entity.Employee;
import com.sonchayan.EmployeeService.exceptionHaandler.NullPointerException;
import com.sonchayan.EmployeeService.exceptionHaandler.UserNotFoundException;
import com.sonchayan.EmployeeService.model.RequestModel;
import com.sonchayan.EmployeeService.model.RequestRegisterModel;
import com.sonchayan.EmployeeService.repository.EmployeeRepository;
import com.sonchayan.EmployeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public boolean saveEmployeeDetails(RequestRegisterModel rrm){
        Employee employee=new Employee();
        employee.setEmp_name(rrm.getEmpName());
        employee.setEmp_email(rrm.getEmpEmail());
        employee.setEmp_address(rrm.getEmpAddress());
        employee.setEmp_password(rrm.getEmpPassword());
        employee.setEmp_phoneNumber(rrm.getEmpPhoneNumber());
        Employee emp=employeeRepository.save(employee);
        if(!emp.getEmp_name().isEmpty()){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public boolean loginEmployeeService(RequestModel requestModel) throws UserNotFoundException, NullPointerException {
        Employee emp=new Employee();
        Optional<Employee> employee=employeeRepository.findById(requestModel.getEmpId());
        if(employee.isPresent()){
            if(employee.get().getEmp_name().equals(requestModel.getEmpName())
                    &&employee.get().getEmp_password().equals(requestModel.getEmpPassword())){
                return true;
            }else {
                throw new UserNotFoundException("Credential exception");
            }
        }else {
            throw new NullPointerException("value is null which is you have entered");
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) throws Exception {
       Optional<Employee> employee=employeeRepository.findById(id);
       if(employee.isPresent()){
           return employee;
       }else{
           throw new NullPointerException("user not found ");
       }

    }

    @Override
    public List<Employee> getMatchedEmployee(RequestRegisterModel requestRegisterModel) {
        Employee emp=new Employee();
        emp.setEmp_name(requestRegisterModel.getEmpName());
        emp.setEmp_email(requestRegisterModel.getEmpEmail());
        emp.setEmp_address(requestRegisterModel.getEmpAddress());
        emp.setEmp_password(requestRegisterModel.getEmpPassword());
        emp.setEmp_phoneNumber(requestRegisterModel.getEmpPhoneNumber());

        ExampleMatcher exampleMatcher=ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example= Example.of(emp,exampleMatcher);

        List<Employee> listOfUsers = employeeRepository.findAll(example);
        return listOfUsers;
    }
}
