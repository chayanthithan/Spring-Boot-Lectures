package com.sonchayan.financeService.service;

import com.sonchayan.financeService.model.RequestModel;

public interface LoginService {

//    Boolean findUserDetails(RequestModel requestModel);

    Boolean findUserDetails(Long id, String password);
}
