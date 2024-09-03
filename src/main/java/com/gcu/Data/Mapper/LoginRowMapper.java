package com.gcu.Data.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.Entity.LoginEntity;

/**
 * RowMapper for LoginModel
 */
public class LoginRowMapper implements RowMapper<LoginEntity> 
{
	@Override
	/**
	 * Maps a row from the users table into a LoginEntity
	 */
	public LoginEntity mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		return new LoginEntity(null, rs.getString("user"), rs.getString("password"));
	}
}
