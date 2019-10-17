package edu.amrita.medishop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.amrita.medishop.model.User;
import edu.amrita.medishop.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/api/users/user/{email}") 
	public User getUser(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	@RequestMapping("/api/users") 
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
}
