package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


    @RestController
    @RequestMapping(UserResource.USERS)
    public class UserResource {
        public static final String USERS = "/users";
        UserController userController;

        @Autowired
        public UserResource(UserController userController) {
            this.userController = userController;
        }

        @GetMapping
        private List<User> users() {
            return userController.readAll();
        }
        /*
        @GetMapping("{id}")
        private User user(@PathVariable String id){
            return userController.getUserById(id);
        }
        @GetMapping("{id}/email")
        private Map<String,String> email(@PathVariable String id){
            return Collections.singletonMap("email",userController.getUserById(id).getEmail());
        }
        @PostMapping
        private void addUser(@RequestBody User user){
            userController.addUder(user);

        }

         */
    }

