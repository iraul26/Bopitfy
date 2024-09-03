package com.gcu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.Business.RegisterBusinessServiceInterface;
import com.gcu.Entity.UserEntity;

@RestController
@RequestMapping("/api/v1/users")
/**
 * Controller class for the Rest API regarding the users in the database
 */
public class UsersRestController {
	
	//dependency injection
	@Autowired
	RegisterBusinessServiceInterface service;	
	
	/**
	 * Constructor
	 * @param service Object to interact with the user database
	 */
	public UsersRestController(RegisterBusinessServiceInterface service) {
		super();
		this.service = service;
	}
	
	/**
	 * This will return all users in an API request like Postman
	 * @return All users
	 */
	@GetMapping("/")
	public ResponseEntity<?> showAllUsers() {
		try {
			List<UserEntity> users = service.getUsers();
			if(users.isEmpty()) {
				//users are empty
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				//users not empty
				return new ResponseEntity<>(users, HttpStatus.OK);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This will return a certain user from the URL or Postman
	 * @param searchTerm The user that will be searched for
	 * @return The searched user
	 */
	@GetMapping("/{searchTerm}")
	public ResponseEntity<?> searchForUser(@PathVariable(name="searchTerm") String searchTerm) {
		try {
			
			 UserEntity user = service.searchUser(searchTerm);
			 
		      if (user != null) {
		    	  //user found
		    	  return new ResponseEntity<>(user, HttpStatus.OK);
		      } 
		      else {
		    	  //user not found
		    	  return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		      }
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}