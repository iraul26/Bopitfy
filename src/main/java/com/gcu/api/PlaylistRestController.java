package com.gcu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.Data.PlaylistDataAccessInterface;
import com.gcu.Entity.PlaylistEntity;

@RestController
@RequestMapping("/api/v1/playlists")
/**
 * Controller class for the Rest API regarding the playlists in the database
 */
public class PlaylistRestController {

	// dependency injection
	@Autowired
	PlaylistDataAccessInterface service;

	/**
	 * Constructor injected dependency
	 * 
	 * @param service Object to interact with the playlist database
	 */
	public PlaylistRestController(PlaylistDataAccessInterface service) {
		super();
		this.service = service;
	}

	/**
	 * This will return a playlist that the user searches for in the URL or Postman
	 * 
	 * @param searchTerm The specified playlist the user wants
	 * @return The playlist searched for
	 */
	@GetMapping("/{searchTerm}")
	@ResponseBody
	public ResponseEntity<?> searchForPlaylist(@PathVariable("searchTerm") String searchTerm) {
		try {
			PlaylistEntity playlist = service.searchPlaylist(searchTerm);

			if (playlist != null) {
				// playlist found
				return new ResponseEntity<>(playlist, HttpStatus.OK);
			} else {
				// playlist not found
				return new ResponseEntity<>("Playlist not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This will return all playlists in an API via URL or Postman
	 * 
	 * @return All playlists in the database
	 */
	@GetMapping("/")
	public ResponseEntity<?> getPlaylists() {
		try {
			List<PlaylistEntity> playlists = service.getAllLists();
			if (playlists.isEmpty()) {
				// playlists empty
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				// playlists not empty
				return new ResponseEntity<>(playlists, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}