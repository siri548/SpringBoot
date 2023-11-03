// Write your code here
package com.example.school.repository;

import java.util.*;

import com.example.school.model.Student;
import com.example.school.model.StudentRowMapper;

public interface StudentRepository {
    ArrayList<Student> getStudents();

    Student getStudentById(int studentId);

    Student updateStudent(int studentId, Student stude);

    Student addStudent(Student student);

    String addStudents(ArrayList<Student> students);

    void deleteStudent(int studentId);
}