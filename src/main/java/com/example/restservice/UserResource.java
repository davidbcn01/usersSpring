package com.example.restservice;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        private List<UserDto> users() {
            return userController.readAll();
        }

        @GetMapping("{id}")
        private UserDto user(@PathVariable Integer id){
            return userController.getUserById(id);
        }
        @GetMapping("{id}/email")
        private Map<String,String> email(@PathVariable Integer id){
            return Collections.singletonMap("email",userController.getUserById(id).getEmail());
        }

        @PostMapping
        private UserDto addUser(@RequestBody UserDto userDto){
           return userController.addUder(userDto);
        }
        @DeleteMapping("/{id}")
        private void userDto(@PathVariable Integer id){
            userController.deleteUser(id);
        }
        @PutMapping("/{id}")
        private UserDto replaceUser(@RequestBody UserDto userDto, @PathVariable Integer id){
            return userController.updateUser(userDto,id);
        }

        @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
        public ResponseEntity<UserDto> updateCustomer(@PathVariable Integer id, @RequestBody JsonPatch patch) {
            return userController.patchUser(id,patch);
        }


    }

