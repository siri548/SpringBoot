package com.example.dinemaster.model;

import javax.persistence.*;

@Entity 
  @Table(name="restaurant")
  public class Restaurant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    String name; 
    @Column(name="address")
    String address; 
    @Column(name="cuisinetype")
    String cuisineType;
    @Column(name="rating")
    int rating;
    public Restaurant(){}
    public Restaurant(int id, String name,String address, String cuisineType, int rating){
        this.id = id;
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.rating= rating;

    }
    public int getId(){
        return id;
    }public void setId(int id){
        this.id = id;
    }public String getName(){
        return name;
    }public void setName(String name){
        this.name= name;
    }public String getAddress(){
        return address;
    }public void setAddress(String address){
        this.address = address;
    }public String getCuisineType(){
        return cuisineType;
    }public void setCuisineType(String cuisineType){
        this.cuisineType= cuisineType;
    }public int getRating(){
        return rating;
    }public void setRating(int rating){
        this.rating = rating;
    }

  }

// Write your code here