package com.example.student.repository;
import org.springframework.repository.JpaRepository;


public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
  

}
