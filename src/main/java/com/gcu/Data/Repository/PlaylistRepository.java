package com.gcu.Data.Repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.Entity.PlaylistEntity;

/**
 * PlaylistRepository to get CRUD actions from CrudRepository
 */
public interface PlaylistRepository extends CrudRepository<PlaylistEntity, Long> {
	/**
	 * Finds a playlist by name
	 * @param playlist The name to search for
	 * @return The playlist with the matching name, if there is one
	 */
	PlaylistEntity findByPlaylistName(String playlist);
}