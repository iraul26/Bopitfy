package com.gcu.Business;

import java.util.List;

import com.gcu.Entity.PlaylistEntity;

/**
 * Interface for LoginBusinessService
 * Describes how the object should interact with the data about a user when logged in
 */
public interface LoginBusinessServiceInterface 
{
	/**
	 * Initialization method called when LoginBusiness is initialized
	 */
	public void init();
	
	/**
	 * Destroy method called when LoginBusiness is stopped
	 */
	public void destroy();
	
	/**
	 * Get all the users' data for when they are logged in
	 * @return User login data (all playlists)
	 */
	public List<PlaylistEntity> getLoginData();
}
