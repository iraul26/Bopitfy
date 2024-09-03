package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.Business.UsersBusinessService;

/**
 * Configuration class for web security functions, mostly login
 */
@Configuration
public class WebSecurityConfig {

	@Autowired
	UsersBusinessService service;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * Method to setup login configuration
	 * @param http The Http Security 
	 * @return A SecurityFilterChain
	 * @throws Exception
	 */
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/", "/home", "/about", "/login", "/register", "/processRegister", "/processCreate", "/processDelete", "/processEdit", "/static/**", "/css/**", "/js/**", "/json/**", "/images/**", "/img/**").permitAll()
						.requestMatchers("/playlists", "/createPlaylist", "/deletePlaylist", "/editPlaylist", "/api/v1/users/**", "/api/v1/playlists/**").authenticated().anyRequest())

				.formLogin(form -> form.loginPage("/login").usernameParameter("username").passwordParameter("password")
						.permitAll().defaultSuccessUrl("/playlists", true))

				.logout(logout -> logout.logoutUrl("/logout").invalidateHttpSession(true).clearAuthentication(true)
						.permitAll().logoutSuccessUrl("/"))
				.httpBasic();

		return http.build();
	}

	/**
	 * Configure our web security to use a user and password service
	 * @param auth The Authentication Manager Builder
	 * @throws Exception
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(service).passwordEncoder(passwordEncoder);
	}
}