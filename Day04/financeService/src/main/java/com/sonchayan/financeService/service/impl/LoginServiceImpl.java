package com.sonchayan.financeService.service.impl;

import com.sonchayan.financeService.entity.RegisterUserDetailsEntity;
import com.sonchayan.financeService.model.RequestModel;
import com.sonchayan.financeService.model.ResponseModel;
import com.sonchayan.financeService.repository.LoginRepository;
import com.sonchayan.financeService.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Boolean findUserDetails(Long id, String password) {
       Optional<RegisterUserDetailsEntity> registerUserDetailsEntity=loginRepository.findById(id);
        RegisterUserDetailsEntity registerUDE = registerUserDetailsEntity.get();

        if(password.equals(registerUDE.getPassword())&&id.equals(registerUDE.getUser_id()))
            return true;
        else
            return false;

    }

    //   @Override
//    public Boolean findUserDetails(RequestModel requestModel) {
//        Optional<RegisterUserDetailsEntity> registerUserDetailsEntity=loginRepository.findById(requestModel.getUser_id());
//
//        RegisterUserDetailsEntity registerUDE=new RegisterUserDetailsEntity();
//
//        if(requestModel.getUser_id()==registerUDE.getUser_id()&& requestModel.getPassword()==registerUDE.getPassword()){
//                return true;
//        }else{
//                return false;
//        }
//    }

}
