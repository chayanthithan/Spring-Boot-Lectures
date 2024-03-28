package com.sonchayan.customerService.service;

import com.sonchayan.customerService.entity.Customer;
import com.sonchayan.customerService.model.RequestModel;
import com.sonchayan.customerService.model.RequestRegisterModel;

import java.util.Optional;

public interface CustomerService {

    boolean saveCustomerDetails(RequestRegisterModel requestRegisterModel);

    boolean loginCustomerData(RequestModel requestModel) throws Exception;

    Optional<Customer> getCustomerByPassword(String password) throws Exception;

    Optional<Customer> getCustomerByNameAndPassword(String customerName, String customerPassword) throws Exception;
}
