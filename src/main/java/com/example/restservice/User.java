package com.example.restservice;


import lombok.Data;

@Data
public class User {
     private String id,email,password,fullname;

    public User(String id, String email, String password, String fullname) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.fullname = fullname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
