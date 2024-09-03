package com.gcu.Business;

import java.util.List;

import com.gcu.Entity.PlaylistEntity;

/**
* This interface is for the business layer of the playlist module
* */
public interface PlaylistBusinessServiceInterface {
	
	/**
	 * Init method, for when the Bean is created
	 */
	public void init();
	
	/**
	 * Method for when the bean is destroyed
	 */
	public void destroy();
	
	/**
	 * Gets all users' playlists
	 */
	public List<PlaylistEntity> getPlaylists();
	
	/**
	 * Searches for a playlist matching a search term
	 */
	public PlaylistEntity searchPlaylist(String playlist);
}