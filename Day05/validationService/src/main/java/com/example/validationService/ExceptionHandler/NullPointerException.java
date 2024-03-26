package com.example.validationService.ExceptionHandler;

public class NullPointerException extends Exception{
//    public String toString(){
//        return "NullPointerException";
//    }

    public NullPointerException() {
    }

    public NullPointerException(String message) {
        super(message);
    }
}
