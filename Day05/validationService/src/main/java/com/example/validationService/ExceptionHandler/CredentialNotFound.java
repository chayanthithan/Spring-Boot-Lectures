package com.example.validationService.ExceptionHandler;

public class CredentialNotFound extends Exception{
    public CredentialNotFound() {
    }

    public CredentialNotFound(String message) {
        super(message);
    }
}
