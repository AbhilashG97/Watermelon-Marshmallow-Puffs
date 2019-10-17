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
	
	/**
	 * This method returns all the users present in the database
	 * @return
	 */
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	/**
	 * This method returns a user with the specified id
	 * @param id: The id of the user
	 * @return: User object with the id specified 
	 */
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	/**
	 * This method returns a user with the specified e-mail
	 * @param email: The email address of the user
	 * @return: User object with the 
	 */
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	/**
	 * This method will be used to add a user to a database
	 * and also to update a user in the database.
	 * @param user: The user object to be added or updated. 
	 */
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
}
