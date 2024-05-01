package com.sonchayan.UserService.service.impl;

import com.sonchayan.UserService.entity.UserEntity;
import com.sonchayan.UserService.exceptionHandler.CredentialNotMatchedException;
import com.sonchayan.UserService.exceptionHandler.UserNotFoundException;
import com.sonchayan.UserService.model.FilterUserModel;
import com.sonchayan.UserService.model.RegisterUserModel;
import com.sonchayan.UserService.model.RequestModel;
import com.sonchayan.UserService.repository.UserRepository;
import com.sonchayan.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean addUserData(RegisterUserModel rum) {
        UserEntity ue=new UserEntity();
        ue.setUserAddress(rum.getUserAddress());
        ue.setUserEmail(rum.getUserEmail());
        ue.setUserPassword(rum.getUserPassword());
        ue.setUserName(rum.getUserName());
        UserEntity userentity=userRepository.save(ue);
        if(!userentity.getUserName().isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean userToLogin(RequestModel requestModel) throws Exception{
        Optional<UserEntity>  ue= Optional.ofNullable(userRepository.findByuserEmail(requestModel.getUserEmail()));
        UserEntity userEntity=ue.get();
        if(ue.isPresent()){
            if(userEntity.getUserEmail().equals(requestModel.getUserEmail())&&
                    userEntity.getUserPassword().equals(requestModel.getUserPassword())){
                return true;
            }else{
                throw new CredentialNotMatchedException("invalid username or password!!");
            }
        }else{
            throw new NullPointerException("user is not found");
        }

    }

    //how to return multiple results

    @Override
    public List<UserEntity> findUsersByName(String userName) throws UserNotFoundException {
        List<UserEntity> ue= (List<UserEntity>) userRepository.findAllByuserName(userName);
        return ue;
//        if(!ue.isEmpty())
//            return ue;
//        else
//            throw new UserNotFoundException("user is not found ");
//

    }

    @Override
    public List<UserEntity> fetchUsersByMatchedField(FilterUserModel filterUserModel) {
        UserEntity ue=new UserEntity();
        ue.setUserName(filterUserModel.getUserName());
        ue.setUserEmail(filterUserModel.getUserEmail());
        ue.setUserAddress(filterUserModel.getUserAddress());
        ue.setUserPassword(filterUserModel.getUserPassword());

        ExampleMatcher exampleMatcher= ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        //This is a class provided by Spring Data that represents an example query
        //it constructs a query based on the provided example entity and matcher
        Example ex= Example.of(ue,exampleMatcher);

        List<UserEntity> listOfUsers=userRepository.findAll(ex);
        return listOfUsers;

    }
}
