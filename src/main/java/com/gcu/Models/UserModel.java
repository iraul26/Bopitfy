package com.gcu.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table("users")
/**
 * This class contains data for a user using our bopify app
 */
public class UserModel {
	@Id
	@Column("user_id")
	private Long id;
	
	@Column("first_name")
	@NotNull(message = "first name is required")
	private String firstName;
	
	@Column("last_name")
	@NotNull(message = "last name is required")
	private String lastName;
	
	@Column("email")
	@NotNull(message = "email is required")
	private String email;
	
	@Column("phone_number")
	@NotNull(message = "phone number is required")
	private String phoneNumber;
	
	@Column("user")
	@NotNull(message = "username is required")
	@Size(min = 4, max = 15, message = "username must be between 3 and 15 characters")
	private String username;
	
	@Column("password")
	@NotNull
	@Size(min = 8, max = 20, message = "password must be between 8 and 20 characters")
	private String password;
	
	/**
	 * Non-default constructor for user
	 * @param firstName User's first name
	 * @param lastName User's last name
	 * @param email User's email
	 * @param phoneNumber User's phone number
	 * @param username User's username
	 * @param password User's password
	 */
	public UserModel(String firstName, String lastName, String username, String password, String email, String phoneNumber) {
		super();
		this.setId(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Default constructor
	 */
	public UserModel() {
		super();
	}
	
	/**
	 * Gets a user's ID
	 * @return The user's ID
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets a user's ID
	 * @param id The user's ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets a user's first name
	 * @return The user's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets a user's first name
	 * @param firstName The user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets a user's last name
	 * @return The user's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets a user's last name
	 * @param lastName The user's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets a user's email
	 * @return The user's email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets a user's email
	 * @param email The user's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets a user's phone number
	 * @return The user's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets a user's phone number
	 * @param phoneNumber The user's phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Gets a user's username
	 * @return The user's username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets a user's username
	 * @param username The user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets a user's password
	 * @return The user's password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets a user's password
	 * @param password The user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", username=" + username + ", password=" + password + "]";
	}
}