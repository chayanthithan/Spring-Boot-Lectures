package com.sonchayan.playerservice.errorHandler;

public class WrongCredentialException extends Exception {
    public WrongCredentialException() {
    }

    public WrongCredentialException(String message) {
        super(message);
    }
}
