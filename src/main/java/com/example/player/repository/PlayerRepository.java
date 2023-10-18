// Write your code here
package com.example.player.repository;

import com.example.player.model.Player;

import java.util.*;

public interface PlayerRepository {
    ArrayList<Players> getPlayers();

    Player getPlayerById(int playerId);

    Player updatePlayer(int playerId, Players player);

    Player addPlayer(Players player);

    void deletePlayer(int playerId);

}