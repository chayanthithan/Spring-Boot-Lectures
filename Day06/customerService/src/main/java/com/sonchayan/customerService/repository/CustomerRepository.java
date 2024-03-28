package com.sonchayan.customerService.repository;

import com.sonchayan.customerService.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findBycustomerPassword(String password);
    //when we use nativeQuery we have to use table names
    //?1 and ?2 means number of parameters
    @Query(value = "SELECT * FROM customer_data u WHERE u.customer_name = ?1 and u.customer_password=?2",
            nativeQuery = true)
    Customer findBycustomerNameAndPassword(String customerName,String customerPassword);
}
