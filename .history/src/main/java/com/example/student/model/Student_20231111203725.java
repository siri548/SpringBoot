package com.example.student.model;
import javax.persistence.*;

@Entity
@Table(name="student")
public class Student{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="name")
private String name;
@Column(name="branch")
String branch;
@Column(name="year")
int year;

public Student(){}
public Student(int id,String name,String branch,int year){
this.id     = id;
this.name   = name;
this.branch = branch;
this.year   = year;
}





}