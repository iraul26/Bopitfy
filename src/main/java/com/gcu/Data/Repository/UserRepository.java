package com.gcu.Data.Repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.Entity.UserEntity;

/**
 * LoginRepository to get CRUD actions from CrudRepository
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	/**
	 * Finds a user by username
	 * @param username The username to search for
	 * @return The user with the matching name, if there is one
	 */
	UserEntity findByUsername(String username);
}