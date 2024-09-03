package com.gcu.Data.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.Entity.PlaylistEntity;

/**
 * Maps rows of the playlists data table to PlaylistModels
 */
public class PlaylistRowMapper implements RowMapper<PlaylistEntity> {

	/**
	 * Maps a row from the playlists table into a PlaylistEntity
	 * @param rs The ResultSet
	 * @param rowNum The row number for the PlaylistModel
	 * @return The resulting PlaylistModel from the mapping
	 */
	@Override
	public PlaylistEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new PlaylistEntity(rs.getLong("playlist_id"), rs.getString("playlist_name"), rs.getInt("user_id"));
	}

}
