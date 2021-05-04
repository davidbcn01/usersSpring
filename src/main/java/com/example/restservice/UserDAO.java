package com.example.restservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User,Integer>{

    Optional<Integer> findById(User user);
    Optional<Integer> deleteById(User user);
    List<User> findAll();
    User save(User user);
}

