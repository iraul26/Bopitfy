package com.gcu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.Data.LoginDataService;
import com.gcu.Data.PlaylistDataService;
import com.gcu.Data.Repository.PlaylistRepository;
import com.gcu.Data.Repository.UserRepository;
import com.gcu.Entity.LoginEntity;
import com.gcu.Entity.PlaylistEntity;
import com.gcu.Entity.UserEntity;

import jakarta.validation.Valid;

/**
 * Controller for login page
 */
@Controller
public class LoginController {

	@Autowired
	PlaylistDataService playlistDataService;
	@Autowired
	LoginDataService loginDataService;
	@Autowired
	UserRepository userDataService;
	@Autowired
	PlaylistRepository playlistRepository;

	/**
	 * Path to login page
	 * 
	 * @param model model
	 * @return login string
	 */
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("loginEntity", new LoginEntity());

		return "login";
	}

	/**
	 * Method to process when login is clicked and checks if users already exists
	 * 
	 * @param loginmodel Loginmodel to process the login from
	 * @param bindingResult Binding result
	 * @param model Model
	 * @return Either login form if not valid user or playlist form
	 */
	@PostMapping("/processLogin")
	public String processLogin(@Valid LoginEntity loginEntity, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login form");
			return "login";
		}

		// check if the user exists and the password is correct
		UserEntity existingUser = userDataService.findByUsername(loginEntity.getUsername());
		if (existingUser == null || !existingUser.getPassword().equals(loginEntity.getPassword())) {
			// attrbutes for thymeleaf page for wrong username or password
			model.addAttribute("title", "Login form");
			model.addAttribute("errorMessage", "Invalid username or password. Please try again.");
			return "login";
		}

		// perform login process
		List<PlaylistEntity> playlists = playlistDataService.getUsersLists(1);
		model.addAttribute("title", "My Playlists");
		model.addAttribute("playlists", playlists);

		return "playlists";
	}

	/**
	 * Path to the playlists page for navbar purposes
	 * 
	 * @param model The model
	 * @return The playlists view
	 */
	@GetMapping("/playlists")
	public String playlists(Model model) {
		List<PlaylistEntity> playlists = playlistDataService.getUsersLists(1);

		model.addAttribute("title", "My Playlists");
		model.addAttribute("playlists", playlists);

		return "playlists";
	}

	/**
	 * Path to the create playlist page
	 * 
	 * @param model model
	 * @return The create playlist page
	 */
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		model.addAttribute("title", "Create a Playlist");
		model.addAttribute("playlistEntity", new PlaylistEntity());

		return "createPlaylist";
	}

	/**
	 * Processes the playlist creation
	 * 
	 * @param playlistModel PlaylistModel
	 * @param bindingResult BindingResult
	 * @param model         model
	 * @param loginmodel    LoginModel
	 * @return The playlists page, whether there are errors or not
	 */
	@PostMapping("/processCreate")
	public String processCreate(@Valid PlaylistEntity playlistEntity, BindingResult bindingResult, Model model) {
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "My Playlists");
			return "playlists";
		}

		// Add the created playlist to the database
		playlistDataService.add(playlistEntity);

		// Get the playlists for the hard-coded user
		List<PlaylistEntity> playlists = playlistDataService.getUsersLists(1);

		// Set attributes
		model.addAttribute("title", "My Playlists");
		model.addAttribute("playlists", playlists);

		return "playlists";
	}

	/**
	 * Path to the delete playlist page
	 * 
	 * @param model model
	 * @return Page to delete playlists
	 */
	@GetMapping("/deletePlaylist")
	public String deletePlaylist(Model model, Model model1) {
		List<PlaylistEntity> playlists = playlistDataService.getUsersLists(1);

		model.addAttribute("title", "My Playlists");
		model.addAttribute("playlists", playlists);

		model1.addAttribute("title", "Delete Playlists");
		model1.addAttribute("playlistEntity", new PlaylistEntity());
		return "deletePlaylist";
	}

	/**
	 * Processes the playlist creation
	 * 
	 * @param playlistModel The playlistModel that is created
	 * @param bindingResult The BindingResult
	 * @param model         The model
	 * @return The playlists page, whether there are errors or not
	 */
	@PostMapping("/processDelete")
	public String processDelete(@Valid PlaylistEntity playlistEntity, BindingResult bindingResult, Model model) {
		// For testing whether a delete occured
		boolean deleted = false;

		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "My Playlists");
			return "deletePlaylists";
		}

		List<PlaylistEntity> playlists = playlistDataService.getUsersLists(1);

		for (PlaylistEntity playlist : playlists) {
			if (playlist.getPlaylistName().equals(playlistEntity.getPlaylistName()) && playlist.getUserID() == 1) {
				// Delete playlist
				playlistDataService.delete(playlist);
				// Set deleted flag
				deleted = true;
			}
		}

		// Set playlists to new list (after delete)
		playlists = playlistDataService.getUsersLists(1);
		model.addAttribute("playlists", playlists);

		if (deleted) {
			// Set attributes
			model.addAttribute("title", "My Playlists");
			return "playlists";
		} else {
			model.addAttribute("errorMessage", "The playlist name you entered was not found. Please try again.");
			return "deletePlaylist";
		}
	}

	/*
	 * Path to the edit a playlist page
	 * 
	 * @param model The model
	 * 
	 * @return The edit playlist page
	 */
	@GetMapping("/editPlaylist")
	public String editPlaylist(Model model) {
		model.addAttribute("title", "Edit Playlist");
		return "editPlaylist";
	}

	/**
	 * Processes an edit to the database and check for errors in the playlist
	 * fields
	 * 
	 * @param playlistEntity The playlist entity that is added
	 * @param bindingResult The BindingResult
	 * @param model The model
	 * @return Either the edit playlist page again or back to playlists with the new,
	 *         updated playlist
	 */
	@PostMapping("/processEdit")
	public String processEdit(@RequestParam("playlistName") String playlistName,
			@RequestParam("newPlaylistName") String newPlaylistName, Model model) {
		// find the playlist entity by its current name
		PlaylistEntity playlist = playlistDataService.searchPlaylist(playlistName);

		// check if the playlist exists
		if (playlist != null) {
			// update the playlist name with the new one
			playlist.setPlaylistName(newPlaylistName);

			// save the updated playlist back to the database
			playlistRepository.save(playlist);

			// redirect to playlists
			return "redirect:playlists";
		} else {
			model.addAttribute("errorMessage", "No playlist found with that name. Please try again.");
			return "editPlaylist";
		}
	}
}
