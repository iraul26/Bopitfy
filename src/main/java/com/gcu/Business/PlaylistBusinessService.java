package com.gcu.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.Data.PlaylistDataAccessInterface;
import com.gcu.Entity.PlaylistEntity;

/**
  * This is the service that will use all the methods from the business interface and send to the controller
  * Gets data about playlists
 */
public class PlaylistBusinessService implements PlaylistBusinessServiceInterface {

	@Autowired
	PlaylistDataAccessInterface playlistDAO;
	
	/**
	 * Init method, for when the Bean is created
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method for when the bean is destroyed
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Gets all users' playlists
	 */
	@Override
	public List<PlaylistEntity> getPlaylists() {
		return playlistDAO.getAllLists();
	}

	/**
	 * Searches for a playlist matching a search term
	 */
	@Override
	public PlaylistEntity searchPlaylist(String playlist) {
		return playlistDAO.searchPlaylist(playlist);
	}

}