package com.gcu.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entity for the users table to be used when logging in
 */
@Table("users")
public class LoginEntity 
{
	@Id
	@Column("user_id")
	private Long id;

	@Column("user")
	private String username;
	
	@Column("password")
	private String password;
	
	/**
	 * Non-default constructor for login entity
	 * @param id User's ID
	 * @param username User's username
	 * @param password User's password
	 */
	public LoginEntity(Long id, String username, String password)
	{
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Default constructor
	 */
	public LoginEntity()
	{	
	}
	
	/**
	 * Get ID of user logging in
	 * @return ID of user
	 */
	public Long getId() 
	{
		return id;
	}

	/**
	 * Set ID of user logging in
	 * @param id ID of user
	 */
	public void setId(Long id) 
	{
		this.id = id;
	}

	/**
	 * Get username of user
	 * @return Username of user
	 */
	public String getUsername() 
	{
		return username;
	}

	/**
	 * Set username of user
	 * @param sername Username of user
	 */
	public void setUsername(String username) 
	{
		this.username = username;
	}

	/**
	 * Get password of user
	 * @return Password of user
	 */
	public String getPassword() 
	{
		return password;
	}

	/**
	 * Set password of user
	 * @param password Password of user
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}
}
