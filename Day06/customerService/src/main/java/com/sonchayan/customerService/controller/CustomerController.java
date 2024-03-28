package com.sonchayan.customerService.controller;

import com.sonchayan.customerService.entity.Customer;
import com.sonchayan.customerService.model.ResponseModel;
import com.sonchayan.customerService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customerservice")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/getCustomer/{password}")
    public ResponseEntity<Customer> findCustomerByPassword(@PathVariable("password") String Password) throws Exception{
       Optional<Customer> customer= customerService.getCustomerByPassword(Password);
       Customer getCustomer=customer.get();
        return new ResponseEntity<>(getCustomer, HttpStatus.OK);

    }
    @GetMapping(value = "/getCustomers",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findCustomerByNameAndPassword(@RequestParam String customerName,@RequestParam String customerPassword) throws Exception{
        Optional<Customer> customer=customerService.getCustomerByNameAndPassword(customerName,customerPassword);
        Customer getCustomer=customer.get();
        return new ResponseEntity<>(getCustomer, HttpStatus.OK);
    }
}
