package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.player.model.Player;
import com.example.player.model.PlayerRowMapper;
import com.example.player.repository.PlayerRepository;

@Service
public class PlayerH2Service implements PlayerRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Player> getPlayers() {
        Collection<Player> players = db.query("select * from team ", new PlayerRowMapper());
        ArrayList<Player> getAllPlayers = new ArrayList<>(players);
        return getAllPlayers;
    }

    @Override
    public Player getPlayerById(int playerId) {
        try {
            Player player = db.queryForObject("select * from team where playerId=?", new PlayerRowMapper(), playerId);
            return player;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Player updatePlayer(int playerId, Player player) {
        if (player.getPlayerName() != null) {
            db.update("update team SET playerName =? where playerId=?", player.getPlayerName(), playerId);
        }
        if (player.getJerseyNumber() != 0) {
            db.update("update team SET jerseyNumber=? where playerId=?", player.getJerseyNumber(), playerId);
        }
        if (player.getRole() != null) {
            db.update("update team SET role=? where playerId=?", player.getRole(), playerId);
        }
        return getPlayerById(playerId);
    }

    @Override
    public Player addPlayer(Player player) {
        db.update("INSERT INTO team(playerId, playerName, jerseyNumber, role) VALUES (?,?,?,?)", player.getPlayerId(),
                player.getPlayerName(), player.getJerseyNumber(), player.getRole());
        Player addedPlayer = db.queryForObject(
                "select * from team where playerId=? and playerName=? and jerseyNumber=? and role=?",
                new PlayerRowMapper(), player.getPlayerId(), player.getPlayerName(), player.getJerseyNumber(),
                player.getRole());
        return addedPlayer;
    }

    @Override
    public void deletePlayer(int playerId) {
        db.update("delete from team where playerId=?", playerId);
    }

}
