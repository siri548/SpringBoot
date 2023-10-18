package com.example.player.model;

import java.sql.SQLException;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

public class PlayerRowMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet rs, int rowNum)
            throws SQLException {
        return new Player(
                rs.getInt("playerId"),
                rs.getString("playerName"),
                rs.getInt("jerseyNumber"),
                rs.getString("role"));

    }

}
