package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class UserController {

    List<User> userRepository;

    @Autowired
    public UserController(List<User> userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> readAll(){
        return userRepository;
    }

    public User getUserById(String id) {
        List<User> u;
        u = userRepository.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
        if(u.size() ==1) return u.get(0);
        else return null;
    }

    public void addUder(User user) {
        userRepository.add(user);
    }
}
