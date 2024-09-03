package com.gcu.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Class containing properties of the login page
 */
@Table(name = "users")
public class LoginModel
{
	@Id
	@Column("user_id")
	private long id;
	
	@NotNull(message="User name is a required field")
	@Size(min=3, max=15, message="User name must be between 3 and 15 characters")
	@Column("user")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=8, max=20, message="Password must be between 8 and 20 characters")
	@Column("password")
	private String password;
	
	/**
	 * Default constructor
	 */
	public LoginModel() 
	{
		
	}
	
	/**
	 * Non-default constructor
	 * @param username User's username
	 * @param password User's password
	 */
	public LoginModel(String username, String password)
	{
		this.setId(id);
		this.username = username;
		this.password = password;
	}

	/**
	 * Get username
	 * @return User's username
	 */
	
	public String getUsername() {
		return username;
	}
	
	/**
	 * Set username
	 * @param username Set username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get password
	 * @return User's password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Set password
	 * @param password Set password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get ID
	 * @return User's ID
	 */
	@Id
	public Long getId() {
		return id;
	}

	/**
	 * Set ID
	 * @param id User's ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
