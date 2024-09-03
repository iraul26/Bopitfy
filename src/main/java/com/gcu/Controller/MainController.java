package com.gcu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for the main pages.
 * Should mainly be used for pages that do not have any used input (display only)
 */
@Controller
public class MainController {

	/**
	 * Returns the home view.
	 * @return The home view (as string, per Spring Boot)
	 */
	@GetMapping({"/", "/home"})
	public String home()
	{
		// Return the home view
		return "home";
	} // end home
	
	/**
	 * Returns the about view.
	 * @return The about view (as string, per Spring Boot)
	 */
	@GetMapping("/about")
	public String about()
	{
		// Return the about view
		return "about";
	} // end about
	
} // end MainController
