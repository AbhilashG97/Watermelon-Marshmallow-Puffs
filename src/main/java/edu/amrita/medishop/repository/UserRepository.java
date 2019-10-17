package edu.amrita.medishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.amrita.medishop.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findUserByEmail(String email);
	
}
