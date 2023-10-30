// Write your code here
package com.example.player.repository;

import com.example.player.model.Player;
import com.example.player.model.PlayerRowMapper;
import java.util.*;


public interface PlayerRepository{

    ArrayList<Player> getPlayers();
    Player getPlayerById(int playerId);

    Player updatePlayer(int playerId, Player player);

    Player addPlayer(Player player);

    void deletePlayer(int playerId);
    
}