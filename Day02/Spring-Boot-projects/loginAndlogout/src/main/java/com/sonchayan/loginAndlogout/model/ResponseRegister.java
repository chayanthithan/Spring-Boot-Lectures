package com.sonchayan.loginAndlogout.model;

public class ResponseRegister {
    private String firstname;
    private String lastname;
    private String status;
    private String message;

    public ResponseRegister() {
    }

    public ResponseRegister(String firstname, String lastname, String status, String message) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
        this.message = message;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
