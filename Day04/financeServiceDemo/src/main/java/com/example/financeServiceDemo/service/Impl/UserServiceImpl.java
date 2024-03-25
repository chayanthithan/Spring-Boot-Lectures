package com.example.financeServiceDemo.service.Impl;

import com.example.financeServiceDemo.entity.RegisterUserDetailsEntity;
import com.example.financeServiceDemo.model.RegisteredRequestModel;
import com.example.financeServiceDemo.model.RequestModel;
import com.example.financeServiceDemo.repository.UserRepository;
import com.example.financeServiceDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    public RegisterServiceImpl(RegisterRepository registerRepository) {
//        this.registerRepository = registerRepository;
//    }

    @Override
    public Boolean saveRegisteredDetails(RegisteredRequestModel registeredRequestModel) {
        RegisterUserDetailsEntity registerUserDetailsEntity=new RegisterUserDetailsEntity();
        registerUserDetailsEntity.setFname(registeredRequestModel.getFname());
        registerUserDetailsEntity.setLname(registeredRequestModel.getLname());
        registerUserDetailsEntity.setAddress(registeredRequestModel.getAddress());
        registerUserDetailsEntity.setMobile(registeredRequestModel.getMobile());
        registerUserDetailsEntity.setEmail(registeredRequestModel.getEmail());
        registerUserDetailsEntity.setPassword(registeredRequestModel.getPassword());
        registerUserDetailsEntity.setCon_password(registeredRequestModel.getCon_password());
        RegisterUserDetailsEntity getResult= userRepository.save(registerUserDetailsEntity);
        if(!getResult.getFname().isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public Boolean loginUserById(RequestModel requestModel) {
       Optional<RegisterUserDetailsEntity> registerUDE= userRepository.findById(requestModel.getUser_id());
       if(registerUDE.get().getUser_id().equals(requestModel.getUser_id())&&registerUDE.get().getPassword().equals(requestModel.getPassword()))
           return true;
       else
           return false;



    }
}
