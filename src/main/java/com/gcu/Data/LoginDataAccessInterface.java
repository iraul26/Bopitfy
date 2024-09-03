package com.gcu.Data;

import java.util.List;
import java.util.Optional;

import com.gcu.Entity.LoginEntity;

/**
 * Interface for LoginDAO
 */
public interface LoginDataAccessInterface <T>
{
	/**
	 * Get login data for all users
	 */
	public List<LoginEntity> findLoginData();
	
	/**
	 * Find a user according to their ID
	 * @param id The desired user's ID
	 * @return The user with that ID if found
	 */
	public Optional<LoginEntity> findById(Long id);
}
