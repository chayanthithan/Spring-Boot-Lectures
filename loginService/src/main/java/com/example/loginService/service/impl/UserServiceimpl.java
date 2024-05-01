package com.example.loginService.service.impl;

import com.example.loginService.entity.User;
import com.example.loginService.model.RequestModel;
import com.example.loginService.repository.UserRepository;
import com.example.loginService.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceimpl implements userService {
    //Autowired
    @Autowired
    private UserRepository repository;

    @Override
    public boolean registerUserDetails(RequestModel requestModel) {
        User user=new User();
        user.setUserName(requestModel.getUserName());
        user.setUserPassword(requestModel.getUserPassword());
        Optional<User> user2= Optional.of(repository.save(user));
        if(user2.isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
