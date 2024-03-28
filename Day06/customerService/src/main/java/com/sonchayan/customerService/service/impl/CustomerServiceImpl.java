package com.sonchayan.customerService.service.impl;

import com.sonchayan.customerService.ExceptionHandleer.CredentialException;
import com.sonchayan.customerService.ExceptionHandleer.UserNotFoundException;
import com.sonchayan.customerService.entity.Customer;
import com.sonchayan.customerService.model.RequestModel;
import com.sonchayan.customerService.model.RequestRegisterModel;
import com.sonchayan.customerService.repository.CustomerRepository;
import com.sonchayan.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public boolean saveCustomerDetails(RequestRegisterModel requestRegisterModel) {
        Customer customer=new Customer();
        customer.setCustomerName(requestRegisterModel.getCustomerName());
        customer.setCustomerEmail(requestRegisterModel.getCustomerEmail());
        customer.setCustomerAddress(requestRegisterModel.getCustomerAddress());
        customer.setCustomerPassword(requestRegisterModel.getCustomerPassword());
        customer.setCustomerMobile(requestRegisterModel.getCustomerMobile());
       Customer getValue= customerRepository.save(customer);
       if(!getValue.getCustomerName().isEmpty())
           return true;
       else
           return false;
    }

    @Override
    public boolean loginCustomerData(RequestModel requestModel) throws Exception{
       Optional<Customer> customer=customerRepository.findById(requestModel.getCustomerId());
       if(customer.isPresent()){
           if(customer.get().getCustomerName().equals(requestModel.getCustomerName())&&
                   customer.get().getCustomerPassword().equals(requestModel.getCustomerPassword())){
               return true;
           }else{
                throw new CredentialException("username or password is mismatch");
           }
       }else{
           throw new UserNotFoundException("user is not found");
       }

    }

    @Override
    public Optional<Customer> getCustomerByPassword(String password) throws Exception{

        Optional<Customer> customer= Optional.ofNullable(customerRepository.findBycustomerPassword(password));
        if(customer.isPresent()){
            return customer;
        }else{
            throw new UserNotFoundException("user is not found");
        }
    }

    @Override
    public Optional<Customer> getCustomerByNameAndPassword(String customerName, String customerPassword) throws Exception{
        Optional<Customer> customer= Optional.ofNullable(customerRepository.findBycustomerNameAndPassword(customerName, customerPassword));
        if(customer.isPresent()){
            return customer;
        }else{
            throw new UserNotFoundException("user is not found");
        }
    }
}
