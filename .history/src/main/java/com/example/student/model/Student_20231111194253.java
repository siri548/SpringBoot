package com.example.student.model;
import javax.persistence.*;
@Entity
@Table(name="")
public class Student {
    @Id private int id;
    private String name;
    private String address;