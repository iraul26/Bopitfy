package com.gcu.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.Data.LoginDataAccessInterface;
import com.gcu.Data.PlaylistDataService;
import com.gcu.Entity.PlaylistEntity;

/**
 * Business service for the data about a user when they are logged in
 */
public class LoginBusinessService implements LoginBusinessServiceInterface
{
	@Autowired
	LoginDataAccessInterface loginDAO;
	@Autowired
	PlaylistDataService playlistDAO;
	
	/**
	 * Display in console when LoginBusinessService is initialized
	 */
	@Override
	public void init() 
	{
		System.out.println("Initialization method of the LoginBusinessService");
	}

	/**
	 * Display in console when LoginBusinessService is stopped
	 */
	@Override
	public void destroy() 
	{
		System.out.println("Destroy method of the LoginBusinessService");
	}

	/**
	 * Get all playlists in the database
	 */
	@Override
	public List<PlaylistEntity> getLoginData() 
	{
		List<PlaylistEntity> playlists = playlistDAO.getAllLists();
		return playlists;
	}

}
