package com.example.restservice;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserDto {

    private int id;
    private String email;
    private String password;
    private String fullname;

        public UserDto(int id, String email, String password, String fullname) {
            this.id = id;
            this.email = email;
            this.password = password;
            this.fullname = fullname;
        }

        public UserDto() {
        }
        public UserDto(User user){
            this.id = user.getId();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.fullname = user.getFullname();
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

