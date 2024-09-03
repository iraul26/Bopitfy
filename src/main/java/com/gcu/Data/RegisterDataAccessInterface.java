package com.gcu.Data;

import java.util.List;

import com.gcu.Entity.UserEntity;

/**
 * The interface for the register module in the data access layer
 */
public interface RegisterDataAccessInterface {
	
	/**
	 * Adds a user to the database
	 * @param user The user to be add to the database
	 */
	public void add(UserEntity user);

	/**
	 * Gets all users from the database
	 * @return All users from the database
	 */
	public List<UserEntity> getUsers();
	
	/**
	 * Searches for users based on a search term
	 * @param searchTerm The term to search the database for
	 * @return The users whose usernames match the search term
	 */
	public UserEntity searchUser(String searchTerm);
}