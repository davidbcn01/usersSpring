package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestServiceApplication {
List<User> userList = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}


	@Bean
	public List<User> userRepository(){
		userList.add(new User("2","fqufew4@gmail.com","fe4f","pepe"));
		userList.add(new User("3","vuiger@gmail.com","gbrtw","juan"));
		userList.add(new User("4","vfgehfrruy@gmail.com","gtjjmu","qwerf"));
		return userList;

	}

}
