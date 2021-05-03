package com.example.restservice;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
     private int id;
    @Column(name = "email")
     private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullname;

    public User(int id, String email, String password, String fullname) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.fullname = fullname;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
