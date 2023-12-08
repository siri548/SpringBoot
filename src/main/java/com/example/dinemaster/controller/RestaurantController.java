  package com.example.dinemaster.controller;
  import com.example.dinemaster.model.Restaurant;
  import com.example.dinemaster.service.RestaurantJpaService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.*;
  import java.util.ArrayList;

  @RestController
  public class RestaurantController{
    @Autowired
    private RestaurantJpaService s1;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> getRestaurants(){
        return s1.getRestaurants();
    }
    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId){
        return s1.getRestaurantById(restaurantId);
    }@PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId, @RequestBody Restaurant restaurant){
        return s1.updateRestaurant(restaurantId, restaurant);
    }@PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return s1.addRestaurant(restaurant);
    }
    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int restaurantId){
        s1.deleteRestaurant(restaurantId);
    }
  }


// Write your code here