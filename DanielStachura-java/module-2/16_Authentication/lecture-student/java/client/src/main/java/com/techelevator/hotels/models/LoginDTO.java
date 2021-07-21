package com.techelevator.hotels.models;

public class LoginDTO {

    private String username;
    private String password;

    //ctor will take a String containing the username,password and put the values in the data members
    public LoginDTO(String credentials) {
        String[] parts = credentials.split(",");    // separate the credentials at the ,
        username = parts[0];    // store the first word in username
        password = parts[1];    // store the second word in the password
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

