package com.gcu.Data.Repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.Entity.LoginEntity;

/**
 * LoginRepository to get CRUD actions from CrudRepository
 */
public interface LoginRepository extends CrudRepository<LoginEntity, Long> 
{
}
