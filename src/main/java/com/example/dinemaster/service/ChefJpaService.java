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
public class ChefJpaService implements ChefRepository {
    @Autowired
    private ChefJpaRepository repo1;
    @Autowired
    private RestaurantJpaRepository repo2;

    @Override
    public ArrayList<Chef> getChefs() {
        List<Chef> li = repo1.findAll();
        ArrayList<Chef> chefs = new ArrayList<>(li);
        return chefs;
    }

    @Override
    public Chef getChefById(int chefId) {
        try {
            Chef chef = repo1.findById(chefId).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }@Override 
    public Chef updateChef(int chefId, Chef chef){
        try{
            Chef newChef = repo1.findById(chefId).get();
            if(chef.getFirstName()!=null){
                newChef.setFirstName(chef.getFirstName());
            }if(chef.getLastName()!=null){
                newChef.setLastName(chef.getLastName());
            }if(chef.getExpertise()!=null){
                newChef.setExpertise(chef.getExpertise());
            }if(chef.getExperienceYears()!=0){
                newChef.setExperienceYears(chef.getExperienceYears());
            }if(chef.getRestaurant()!=null){
                Restaurant r1 = chef.getRestaurant();
                int restaurantId = r1.getId();
                Restaurant r2 = repo2.findById(restaurantId).get();
                newChef.setRestaurant(r2);
            }repo1.save(newChef);
            return newChef;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override 
    public Chef addChef(Chef chef){
        Restaurant  r1 = chef.getRestaurant();
        int restaurantId = r1.getId();
        try{
           Restaurant newRestaurant = repo2.findById(restaurantId).get();
           chef.setRestaurant(newRestaurant);
           repo1.save(chef);
           return chef;
        }catch(Exception e){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override 
    public void deleteChef(int chefId){
        try{
            repo1.deleteById(chefId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
    @Override 
    public Restaurant getChefRestaurant(int chefId){
        try{
            Chef chef = repo1.findById(chefId).get();
            Restaurant r1 = chef.getRestaurant();
            int n = r1.getId();
            Restaurant newRestaurant = repo2.findById(n).get();
            return newRestaurant;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

// Write your code here