package com.example.HospitalService.exceptionHandler;

public class CredentialNotMatchedException extends Exception{
    public CredentialNotMatchedException() {
    }

    public CredentialNotMatchedException(String message) {
        super(message);
    }
}
