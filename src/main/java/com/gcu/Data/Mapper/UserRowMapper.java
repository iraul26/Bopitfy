package com.gcu.Data.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.Entity.UserEntity;

/**
 * Maps rows of the users data table to user entity
 */
public class UserRowMapper implements RowMapper<UserEntity> {

	/**
	 * Maps a row from the users table into a UserEntity
	 */
	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UserEntity(rs.getString("first_name"), rs.getString("last_name"), rs.getString("user"),
				rs.getString("password"), rs.getString("email"), rs.getString("phone_number"));
	}
}