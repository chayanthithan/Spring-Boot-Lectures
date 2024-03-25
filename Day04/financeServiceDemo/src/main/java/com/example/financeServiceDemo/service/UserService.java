package com.example.financeServiceDemo.service;

import com.example.financeServiceDemo.model.RegisteredRequestModel;
import com.example.financeServiceDemo.model.RequestModel;

public interface UserService {
    Boolean saveRegisteredDetails(RegisteredRequestModel registeredRequestModel);

    Boolean loginUserById(RequestModel requestModel);
}
