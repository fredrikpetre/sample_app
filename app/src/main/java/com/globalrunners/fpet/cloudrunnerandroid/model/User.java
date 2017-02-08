package com.globalrunners.fpet.cloudrunnerandroid.model;


public class User {

    private String username;

    private String password;

    private String token;
    public User(String username, String password, String token){
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String password() {
        return password;
    }

    public String getToken() {
        return token;
    }
}
