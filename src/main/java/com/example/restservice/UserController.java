package com.example.restservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class UserController {

    UserDAO userDAO;
    @Autowired
    public UserController(UserDAO userDao){
        this.userDAO = userDao;
    }
    public List<UserDto> readAll() {

        List<UserDto> users = userDAO.findAll().stream().map(UserDto::new).collect(Collectors.toList());
        return users;
    }

    public UserDto getUserById(Integer id) {
        Optional<User> user =userDAO.findById(id);
        if(user.isPresent()){
            return new UserDto(user.get());
        }else{
            return null;
        }
    }
    public UserDto addUder(UserDto userDto) {
        User user = new User(userDto);
        userDAO.save(user);
        return userDto;
    }
    public void deleteUser(Integer id) {
      userDAO.deleteById(id);

    }

    public UserDto updateUser(UserDto userDto, Integer id) {
        User user = new User(userDto);
        return userDAO.findById(id).map(u ->{
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setFullname(user.getFullname());
            userDAO.save(u);
            return new UserDto(u);
        }).orElseGet(()->{
            UserDto userDto1 = new UserDto(userDAO.save(user));
            return userDto1;
        });
    }

    public ResponseEntity<UserDto> patchUser(Integer id, JsonPatch patch) {

        try {
            UserDto user = getUserById(id);
            UserDto userPatched = applyPatchToUser(patch, user);
            userDAO.save(new User(userPatched));
            return ResponseEntity.ok(userPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    ObjectMapper objectMapper = new ObjectMapper();
    public UserDto applyPatchToUser(JsonPatch patch, UserDto userDto) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(userDto, JsonNode.class));
        return objectMapper.treeToValue(patched, UserDto.class);
    }
    /*@Autowired
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
    */

}
