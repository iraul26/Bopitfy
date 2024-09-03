package com.gcu.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;

/**
 * Entity for the playlists table
 */
@Table("playlists")
public class PlaylistEntity {

	@Id
	@Column("playlist_id")
	private Long id;
	
	@Column("playlist_name")
	@NotNull(message="Name is a required field")
	private String playlistName;
	
	@Column("user_id")
	private int userID;
	
	/**
	 * Default Constructor
	 */
	public PlaylistEntity() {
		super();
	}

	/**
	 * Non-Default Constructor
	 * @param id The playlist's ID
	 * @param playlistName The name of the playlist
	 * @param userID The ID of the user that the playlist is associated
	 */
	public PlaylistEntity(Long id, @NotNull(message = "Name is a required field") String playlistName, int userID) {
		super();
		this.id = id;
		this.playlistName = playlistName;
		this.userID = userID;
	}
	
	/**
	 * Get playlist ID
	 * @return Playlist's ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set playlist ID
	 * @param id Playlist's ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get playlist name
	 * @return Playlist's name
	 */
	public String getPlaylistName() {
		return playlistName;
	}
	
	/**
	 * Set playlist name
	 * @param playlistName Name of playlist
	 */
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	/**
	 * Get user's ID
	 * @return ID of the user that created the playlist
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * Set user's ID
	 * @param userID ID of the user that created the playlist
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
