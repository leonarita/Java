package com.angularClient.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
    // standard constructors
    
	@Autowired
    private UserRepository userRepository;
 
    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    @GetMapping("/users/{id}")
    public Optional<User> getUsersById(@PathVariable("id") long id) {
        return userRepository.findById(id);
    }
 
    @PostMapping("/users")
    void addUser(@RequestBody User user) {

    	List<User> users = (List<User>) userRepository.findAll();
    	User userMayToUpdate = null;
    	
    	for (User i : users) {
    		if (i.getEmail().equals(user.getEmail())) {
    			userMayToUpdate = i;
    			userMayToUpdate.setName(user.getName());
    			break;
    		}
    	}
    	
    	if (userMayToUpdate == null)
    		userMayToUpdate = user;
    	
        userRepository.save(userMayToUpdate);
    }
    
    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }
}