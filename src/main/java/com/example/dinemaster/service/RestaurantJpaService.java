package com.example.dinemaster.service;

import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantJpaService implements RestaurantRepository {
    @Autowired
    private RestaurantJpaRepository repo2;

    @Override
    public ArrayList<Restaurant> getRestaurants() {
        List<Restaurant> li = repo2.findAll();
        ArrayList<Restaurant> restaurants = new ArrayList<>(li);
        return restaurants;
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        try {
            Restaurant r1 = repo2.findById(restaurantId).get();
            return r1;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {
        try {
            Restaurant r1 = repo2.findById(restaurantId).get();
            if (restaurant.getName() != null) {
                r1.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != null) {
                r1.setAddress(restaurant.getAddress());
            }
            if (restaurant.getCuisineType() != null) {
                r1.setCuisineType(restaurant.getCuisineType());
            }
            if (restaurant.getRating() != 0) {
                r1.setRating(restaurant.getRating());
            }
            repo2.save(r1);
            return r1;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        repo2.save(restaurant);
        return restaurant;
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        try {
            repo2.deleteById(restaurantId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}

// Write your code here