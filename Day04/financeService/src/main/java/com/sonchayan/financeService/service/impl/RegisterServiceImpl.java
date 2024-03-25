package com.sonchayan.financeService.service.impl;

import com.sonchayan.financeService.entity.RegisterUserDetailsEntity;
import com.sonchayan.financeService.model.RegisterRequestModel;
import com.sonchayan.financeService.repository.RegisterRepository;
import com.sonchayan.financeService.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterRepository registerRepository;
    @Override
    public Boolean saveRegisteredUserDetails(RegisterRequestModel registerRequestModel) {
        RegisterUserDetailsEntity registerUserDetailsEntity=new RegisterUserDetailsEntity();
        registerUserDetailsEntity.setFname(registerRequestModel.getFname());
        registerUserDetailsEntity.setLname(registerRequestModel.getLname());
        registerUserDetailsEntity.setAddress(registerRequestModel.getAddress());
        registerUserDetailsEntity.setEmail(registerRequestModel.getEmail());
        registerUserDetailsEntity.setMobile(registerRequestModel.getMobile());
        registerUserDetailsEntity.setPassword(registerRequestModel.getPassword());
        registerUserDetailsEntity.setCon_password(registerRequestModel.getCon_password());
        RegisterUserDetailsEntity getResult=registerRepository.save(registerUserDetailsEntity);
        if(!getResult.getFname().isEmpty())
            return true;
        else
            return false;
    }
}
