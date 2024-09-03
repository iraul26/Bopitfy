package com.gcu.Data;

import java.util.List;

import com.gcu.Entity.PlaylistEntity;

/**
 * Interface for object that interacts with the playlist database
 */
public interface PlaylistDataAccessInterface {

	/**
	 * Gets the playlists that were created by a specified user
	 * 
	 * @param userID ID of the user that created the playlist
	 * @return List of playlists that match the userID
	 */
	public List<PlaylistEntity> getUsersLists(int userID);
	
	/**
	 * Adds a playlist to the Database
	 * 
	 * @param playlist The playlist to be added to the database
	 */
	public void add(PlaylistEntity playlist);
	
	/**
	 * Searches the playlist database for a search term 
	 * @param searchTerm The term to search for
	 * @return Playlists whose names match the search term
	 */
	public PlaylistEntity searchPlaylist(String searchTerm);
	
	/**
	 * Gets all playlists in the database
	 * @return All playlists in the database
	 */
	public List<PlaylistEntity> getAllLists();
}