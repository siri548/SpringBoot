package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.player.repository.PlayerRepository;
import com.example.player.model.PlayerRowMapper;
import com.example.player.model.Player;

@Service
public class PlayerH2Service implements PlayerRepository {
  @Autowired
  private JdbcTemplate db;

  @Override
  public ArrayList<Players> getPlayers() {
    List<Players> PlayerList = db.query("select * from player", new PlayerRowMapper());
    ArrayList<Players> allplayers = new ArrayList<>(PlayerList);
    return allplayers;
  }

  @Override
  public Player getPlayerById(int playerId) {
    try {
      Players existing = db.queryForObject("select * from player when id =?", new PlayerRowMapper(), playerId);
      return existing;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public Player addPlayer(Players player) {
    db.update("insert into player(playerId, name, jerseyNumber, role) values(?,?,?,?)", player.getId(),
        player.getPlayerName(), player.getJerseyNumber(), player.getRole());
    Player savedPlayer = db.queryForObject(
        "select * from book where name =? and playerId=?, playerjerseyNumber=?,playerrole=?", new PlayerRowMapper(),
        player.getId(), player.getPlayerName(), player.getJerseyNumber(), player.getRole());

    return savedPlayer;
  }

  @Override
  public Players updatePlayer(int playerId, Players player) {
    if (player.getPlayerName() != null) {
      db.update("update player set name =? where id =?", player.getPlayerName(), playerId);
    }
    if (player.getJerseyNumber() != 0) {
      db.update("update player set jerseyNumber=? where id =?", player.getJerseyNumber(), playerId);
    }
    if (player.getRole() != null) {
      db.update("update player ser role=? where id=?", player.getRole(), playerId);
    }
    return player;
  }

  @Override
  public void deletePlayer(int playerId) {
    db.update("delete from player where id =?", playerId);
  }

}