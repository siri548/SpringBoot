package com.example.student.repository;
import com.org.springframework.repository.JpaRepository;


public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
  

}
