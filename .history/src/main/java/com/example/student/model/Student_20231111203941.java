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
    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    public String getBranch(){
    return branch;
    }
    public void setBranch(String branch){
    this.branch = branch;
    }

}