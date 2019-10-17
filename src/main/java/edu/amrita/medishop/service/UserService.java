package edu.amrita.medishop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.amrita.medishop.model.User;
import edu.amrita.medishop.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
}
