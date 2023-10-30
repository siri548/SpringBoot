package com.example.player.model;

import com.example.player.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRowMapper implements org.springframework.jdbc.core.RowMapper<Player>{
    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Player(
           rs.getInt("playerId"), 
           rs.getString("playerName"),
           rs.getInt("jerseyNumber"),
           rs.getString("role"));
    }

}