package com.gcu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.Data.RegisterDAO;
import com.gcu.Entity.UserEntity;

import jakarta.validation.Valid;

/**
 * Controller for everything registration related
 */
@Controller
public class RegisterController {
	
	@Autowired
	RegisterDAO userDataService;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	/**
	 * Path to the register page 
	 * @param model Object to pass data from controller to view
	 * @return The register page
	 */
	@GetMapping("/register")
	public String register(Model model)
	{
		model.addAttribute("user", new UserEntity());
		return "register";
	}
	
	/**
	 * Processes adding the newly registered user as a user to the database and return his playlists
	 * @param user New user
	 * @param bindingResult BindingResult
	 * @param password The password the user enters in the register form
	 * @return Either register again if errors or the playlist page
	 */
	@PostMapping("/processRegister")
    public String processRegister(@Valid @ModelAttribute("user") UserEntity user, BindingResult bindingResult, @RequestParam("password") String password) {
        if (bindingResult.hasErrors()) {
            //if there are validation errors, return to the registration form
            return "register";
        } else {
            //encode the password useing the encoder
        	String encodedPassword = passwordEncoder.encode(password);
        	
        	//set the encoded password to the user entity
        	user.setPassword(encodedPassword);
        	
        	//add the user to the database
        	userDataService.add(user);
        	
        	//redirect to playlists
        	return "playlists";
        }
    }
}