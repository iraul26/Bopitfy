package com.gcu.Business;

import java.util.List;

import com.gcu.Entity.UserEntity;

/**
 * This interface is for the business layer of the registration module
 */
public interface RegisterBusinessServiceInterface {
	
	/**
	 * Test method for the connection to the business service
	 */
	public void test();
	
	/**
	 * Init method, for when the Bean is created
	 */
	public void init();
	
	/**
	 * Method for when the bean is destroyed
	 */
	public void destroy();
	
	/**
	 * Gets all users
	 */
	public List<UserEntity> getUsers();
	
	/**
	 * Searches for a user matching a search term
	 */
	public UserEntity searchUser(String user);
	
}
