package com.example.student.model;
import javax.persistence.*;
@Entity
public class Student {
    @Id private int id;
    private String name;
    private String address;