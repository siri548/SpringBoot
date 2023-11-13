package com.example.student.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.
import com.example.student.model.Student;


public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
  

}
