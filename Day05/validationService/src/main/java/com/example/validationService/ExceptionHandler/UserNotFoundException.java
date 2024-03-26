package com.example.validationService.ExceptionHandler;

public class UserNotFoundException extends Exception{
//    public String toString(){
//        return "UserNotFound";
//    }


    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
