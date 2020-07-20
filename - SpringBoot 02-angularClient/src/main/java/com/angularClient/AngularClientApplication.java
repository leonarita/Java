package com.angularClient;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.angularClient.client.User;
import com.angularClient.client.UserRepository;

@SpringBootApplication
public class AngularClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularClientApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(UserRepository userRepository) {
		
		if (userRepository.count() == 0) {
	        return args -> {
	            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
	                User user = new User(name, name.toLowerCase() + "@domain.com");
	                userRepository.save(user);
	            });
	            userRepository.findAll().forEach(System.out::println);
	        };
		}
		else {
			return null;
		}
    }

}
