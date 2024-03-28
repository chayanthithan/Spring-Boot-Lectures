package com.sonchayan.EmployeeService.exceptionHaandler;

public class CredentialNotFoundException extends Exception{
    public CredentialNotFoundException() {
    }

    public CredentialNotFoundException(String message) {
        super(message);
    }
}
