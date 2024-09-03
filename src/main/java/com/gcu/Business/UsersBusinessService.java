package com.gcu.Business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.Data.Repository.UserRepository;
import com.gcu.Entity.UserEntity;

/**
 * Service to interact with users
 */
@Service
public class UsersBusinessService implements UserDetailsService {
	
	@Autowired
	UserRepository service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//new user entity from the service
		UserEntity user = service.findByUsername(username);
		
		//if user is not null, add it to the authorities list to grant access
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else {
			//if username is not found
			throw new UsernameNotFoundException("username not found");
		}
	}
}