package com.gcu.Data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gcu.Data.Repository.UserRepository;
import com.gcu.Entity.UserEntity;

/**
 * Register Data Access Object that will pass data to the business layer to pass to the controller
 */
@Repository
public class RegisterDAO implements RegisterDataAccessInterface {
	
	@Autowired
	UserRepository userRepo;

	/**
	 * Adds a user to the Database
	 * @param user The user to be added to the database
	 */
	@Override
	public void add(UserEntity user) {
		userRepo.save(user);
	}

	/**
	 * Gets all users from the database
	 */
	@Override
	public List<UserEntity> getUsers() {
		return (List<UserEntity>) userRepo.findAll();
	}

	/**
	 * Gets a certain user from the database
	 * @param searchTerm The matching user
	 */
	@Override
	public UserEntity searchUser(String searchTerm) {
		UserEntity user = userRepo.findByUsername(searchTerm);
		return user;
	}
}