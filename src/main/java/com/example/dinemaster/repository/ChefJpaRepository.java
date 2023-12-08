package com.example.dinemaster.repository;
import com.example.dinemaster.model.Chef;
import com.example.dinemaster.model.Restaurant;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;
 @Repository
 public interface ChefJpaRepository extends JpaRepository<Chef, Integer>{}


// Write your code here