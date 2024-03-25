package com.sonchayan.financeService.service;

import com.sonchayan.financeService.model.RegisterRequestModel;

public interface RegisterService {
    Boolean saveRegisteredUserDetails(RegisterRequestModel registerRequestModel);
}
