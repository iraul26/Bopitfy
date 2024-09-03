package com.gcu.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gcu.Data.Repository.LoginRepository;
import com.gcu.Entity.LoginEntity;

/**
 * Data Service for Login
 */
@Repository
@Service
public class LoginDataService implements LoginDataAccessInterface<LoginEntity>
{
	@Autowired
	private LoginRepository loginRepository;

	/**
	 * Get login data for all users
	 */
	public List<LoginEntity> findLoginData()
	{
		// Array to hold data from the database
		List<LoginEntity> loginData = new ArrayList<LoginEntity>();
		try
		{
			// Get login data
			Iterable<LoginEntity> loginIterable = loginRepository.findAll();
			
			// Add all user data
			for (LoginEntity loginEnt : loginIterable)
			{
				loginData.add(loginEnt);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		// Return array with username and password from database
		return loginData;
	}
	
	@Override
	/**
	 * Find a user by their ID
	 */
	public Optional<LoginEntity> findById(Long id) 
	{
		return loginRepository.findById(id);
	}

}
