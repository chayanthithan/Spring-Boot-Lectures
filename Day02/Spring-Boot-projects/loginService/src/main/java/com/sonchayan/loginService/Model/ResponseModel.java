package com.sonchayan.loginService.Model;

public class ResponseModel {
    private String result;
    private String username;

    public ResponseModel() {
    }

    public ResponseModel(String result, String username) {
        this.result = result;
        this.username = username;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
