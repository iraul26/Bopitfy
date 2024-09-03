package com.gcu.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.Data.RegisterDataAccessInterface;
import com.gcu.Entity.UserEntity;

/**
 * this is the registration service that will use all the methods from the business interface and send to the controller
 */
public class RegisterBusinessService implements RegisterBusinessServiceInterface {
	
	@Autowired
	RegisterDataAccessInterface registerDAO;

	/**
	 * Test method for the connection to the business service
	 */
	@Override
	public void test() {
		System.out.println("In the RegisterBusinessService");
		
	}

	/**
	 * Init method, for when the Bean is created
	 */
	@Override
	public void init() {
		System.out.println("init method of the RegisterBusinessService");
		
	}

	/**
	 * Method for when the bean is destroyed
	 */
	@Override
	public void destroy() {
		System.out.println("destroy method of the RegisterBusinessService");
		
	}

	/**
	 * Gets all users
	 */
	@Override
	public List<UserEntity> getUsers() {
		return registerDAO.getUsers();
	}

	/**
	 * Searches for a user matching a search term
	 */
	@Override
	public UserEntity searchUser(String user) {
		return registerDAO.searchUser(user);
	}
}