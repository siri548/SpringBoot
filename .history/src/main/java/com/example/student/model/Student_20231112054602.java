package com.example.student.model;
import javax.persistence.*;

@Entity
@Table(name="student")
public class Student{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private long id;
@Column(name="name")
private String name;
@Column(name="department")
String department;
@Column(name="year")
int year;
public Student(){}
public Student(int id,String name,String department ,int year){
this.id     = id;
this.name   = name;
this.department = department;
this.year   = year;
}
    /**
     * @return int return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(t id) {
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
    public String getDepartment(){
    return department;
    }
    public void setDepartment(String department){
    this.department = department;
    }
public int getYear(){
return year;
}public void setYear(int year){
this.year = year;
}
}