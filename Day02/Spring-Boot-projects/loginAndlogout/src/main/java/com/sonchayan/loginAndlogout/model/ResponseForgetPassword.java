package com.sonchayan.loginAndlogout.model;

public class ResponseForgetPassword {
    private String email;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String message;
    private String status;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResponseForgetPassword() {
    }

    public ResponseForgetPassword(String email,String message,String status) {

        this.email = email;
        this.message = message;
        this.status = status;

    }
}
