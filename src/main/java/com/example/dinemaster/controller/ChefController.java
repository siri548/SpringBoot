package com.example.dinemaster.controller;

import com.example.dinemaster.model.*;

import com.example.dinemaster.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController 
public class ChefController{
  @Autowired
  private ChefJpaService s2;
  @GetMapping("/restaurants/chefs")
  public ArrayList<Chef> getChefs(){
    return s2.getChefs();
  }@GetMapping("/restaurants/chefs/{chefId}")
  public Chef getChefById(@PathVariable("chefId") int chefId){
    return s2.getChefById(chefId);
  }@PostMapping("/restaurants/chefs")
  public Chef addChef(@RequestBody Chef chef){
    return s2.addChef(chef);
  }@PutMapping("/restaurants/chefs/{chefId}")
  public Chef updateChef(@PathVariable("chefId") int chefId, @RequestBody Chef chef){
    return s2.updateChef(chefId, chef);
  }@DeleteMapping("/restaurants/chefs/{chefId}")
  public void deleteChef(@PathVariable("chefId") int chefId){
    s2.deleteChef(chefId);
  }@GetMapping("/chefs/{chefId}/restaurant")
  public Restaurant getChefRestaurant(@PathVariable("chefId") int chefId){
    return s2.getChefRestaurant(chefId);
  }
}
// Write your code here