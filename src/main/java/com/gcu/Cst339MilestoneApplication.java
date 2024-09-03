package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan("com.gcu")
/**
 * Main app
 */
public class Cst339MilestoneApplication {

	/**
	 * Main method, runs the app
	 * @param args Arguments for main
	 */
	public static void main(String[] args) {
		//password from user in the database
		String plainTextPassword = "heypersonreadingthis";

		//encode their password and update it in the db
		String encoded = new BCryptPasswordEncoder().encode(plainTextPassword);
		System.out.println(plainTextPassword + " encoded is " + encoded);

		SpringApplication.run(Cst339MilestoneApplication.class, args);
	}
}