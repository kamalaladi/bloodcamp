package com.example.Blood_Camp.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


public class Login {

    @NotEmpty(message = "Please enter the email")
    private String email;

    @NotEmpty(message = "Please enter the password")
    private String password;

    public Login(){}

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
