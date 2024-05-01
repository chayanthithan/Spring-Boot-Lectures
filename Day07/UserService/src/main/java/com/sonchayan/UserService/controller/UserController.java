package com.sonchayan.UserService.controller;

import com.sonchayan.UserService.entity.UserEntity;
import com.sonchayan.UserService.model.FilterUserModel;
import com.sonchayan.UserService.model.ResponseModel;
import com.sonchayan.UserService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/userservice")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;
    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEntity> fetchUserDataByMatchField(@RequestBody @Valid FilterUserModel filterUserModel){
        ResponseModel rm=new ResponseModel();
        List<UserEntity> getUsers=userService.fetchUsersByMatchedField(filterUserModel);
        return getUsers;
    }
//i18n-->internationalization
//    @GetMapping("/i18n")
//    public ResponseEntity<String> throwErrorLogin(@RequestHeader(name = "Accept-Language",required = false)Locale locale){
//       return new ResponseEntity<>(messageSource.getMessage("user.wrong.credential",null,locale), HttpStatus.OK);
//    }

    @GetMapping("/internationalisation")
    public ResponseEntity<String> throwErrorLogin(
            @RequestHeader(name = "Accept-Language",required = false)Locale locale){//ta

        return new ResponseEntity<>(
//                messageSource.getMessage("user.wrong.credential",null,locale),HttpStatus.OK);
                resourceBundleMessageSource.getMessage("user.wrong.credential",null,locale),HttpStatus.OK);
        //give a key it will return a message
    }
}
