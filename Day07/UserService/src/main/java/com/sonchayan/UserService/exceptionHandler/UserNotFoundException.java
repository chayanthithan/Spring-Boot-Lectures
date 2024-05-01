package com.sonchayan.UserService.exceptionHandler;

    public class UserNotFoundException extends Exception {
        public UserNotFoundException() {
        }

        public UserNotFoundException(String message) {
            super(message);
        }
    }

