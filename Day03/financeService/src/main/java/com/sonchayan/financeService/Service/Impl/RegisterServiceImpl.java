package com.sonchayan.financeService.Service.Impl;

import com.sonchayan.financeService.Entity.RegisterUserDetailsEntity;
import com.sonchayan.financeService.Model.RegisterUserModel;
import com.sonchayan.financeService.Repository.RegisterRepository;
import com.sonchayan.financeService.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterRepository registerRepository;
    @Override
    public Boolean createRegisterUser(RegisterUserModel registerUserModel) {
        RegisterUserDetailsEntity registerUserDetailsEntity=new RegisterUserDetailsEntity();
        registerUserDetailsEntity.setFname(registerUserModel.getFname());
        registerUserDetailsEntity.setLname(registerUserModel.getLname());
        registerUserDetailsEntity.setEmail(registerUserModel.getEmail());
        registerUserDetailsEntity.setAddress(registerUserModel.getAddress());
        registerUserDetailsEntity.setMobile(registerUserModel.getMobile());
        registerUserDetailsEntity.setPassword(registerUserModel.getPassword());

        RegisterUserDetailsEntity returnedEntity= registerRepository.save(registerUserDetailsEntity);
        if(!returnedEntity.getFname().isEmpty())
            return true;
        else
            return false;


    }
}
