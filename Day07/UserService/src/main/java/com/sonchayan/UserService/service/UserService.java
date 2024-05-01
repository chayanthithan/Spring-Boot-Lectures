package com.sonchayan.UserService.service;

import com.sonchayan.UserService.entity.UserEntity;
import com.sonchayan.UserService.exceptionHandler.UserNotFoundException;
import com.sonchayan.UserService.model.FilterUserModel;
import com.sonchayan.UserService.model.RegisterUserModel;
import com.sonchayan.UserService.model.RequestModel;
import java.util.List;

public interface UserService {
    boolean addUserData(RegisterUserModel rum);

    boolean userToLogin(RequestModel requestModel) throws Exception;

    List<UserEntity> findUsersByName(String userName) throws UserNotFoundException;

    List<UserEntity> fetchUsersByMatchedField(FilterUserModel filterUserModel);
}
