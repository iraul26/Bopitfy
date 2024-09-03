package com.gcu.Data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gcu.Data.Repository.PlaylistRepository;
import com.gcu.Entity.PlaylistEntity;

/**
 * Service to interact with the playlists database table
 */
@Repository
public class PlaylistDataService implements PlaylistDataAccessInterface {

	@Autowired
	PlaylistRepository playlistRepository;

	/**
	 * Gets the playlists that were created by a specified user
	 * 
	 * @param userID ID of the user that created the playlist
	 * @return List of playlists that match the userID
	 */
	@Override
	public List<PlaylistEntity> getUsersLists(int userID) {
		List<PlaylistEntity> playlists = new ArrayList<PlaylistEntity>();

		try {
			// Get all playlists
			Iterable<PlaylistEntity> playlistIterable = playlistRepository.findAll();

			// Add all playlists that match hard-coded ID
			for (PlaylistEntity playlist : playlistIterable) {
				if (playlist.getUserID() == userID) {
					playlists.add(playlist);
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		} // end try catch

		// Return the matching playlists
		return playlists;
	}

	/**
	 * Adds a playlist to the Database
	 * 
	 * @param playlist The playlist to be added to the database
	 */
	@Override
	public void add(PlaylistEntity playlist) {
		playlist.setUserID(1);
		playlistRepository.save(playlist);
	}

	/**
	 * Deletes a playlist from the Database
	 * 
	 * @param playlist Playlist to be deleted from database
	 */
	public void delete(PlaylistEntity playlist) {
		playlistRepository.delete(playlist);
	}

	/**
	 * Finds a playlist entity by its name and retrieves it
	 */
	@Override
	public PlaylistEntity searchPlaylist(String playlistName) {
		PlaylistEntity playlist = playlistRepository.findByPlaylistName(playlistName);
		return playlist;
	}

	/**
	 * Get all playlists stored in the database
	 */
	@Override
	public List<PlaylistEntity> getAllLists() {
		//Return the matching playlists
		return (List<PlaylistEntity>) playlistRepository.findAll();
	}
}