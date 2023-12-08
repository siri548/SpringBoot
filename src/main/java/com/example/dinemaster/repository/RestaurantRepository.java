package com.example.dinemaster.repository;

import com.example.dinemaster.model.Restaurant;
import java.util.ArrayList;

public interface RestaurantRepository {
  ArrayList<Restaurant> getRestaurants();

  Restaurant getRestaurantById(int restaurantId);

  Restaurant updateRestaurant(int restaurantId, Restaurant restaurant);

  Restaurant addRestaurant(Restaurant restaurant);

  
void deleteRestaurant(int restaurantId);
}

// Write your code here