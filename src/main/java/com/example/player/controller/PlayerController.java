  package com.example.player.controller;
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
  import java.util.*;
  import com.example.player.model.Player;
  import com.example.player.model.PlayerRowMapper;
  import com.example.player.service.PlayerH2Service;
   @RestController
  public class PlayerController{
    public PlayerH2Service playerService;
    @Autowired 
    public PlayerController(PlayerH2Service playerService){
        this.playerService = playerService;
    }
    @GetMapping("/players")
    public ArrayList<Player> getPlayers(){
        return playerService.getPlayers();
    }
    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
        return playerService.getPlayerById(playerId);
    }
    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }
    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player){
        return playerService.updatePlayer(playerId, player);
    }
    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerService.deletePlayer(playerId);

    }

  }

