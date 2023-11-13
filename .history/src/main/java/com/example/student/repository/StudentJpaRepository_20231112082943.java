package com.example.student.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.student.model.Student;

@
public interface StudentJpaRepository extends JpaRepository<Student, Long> {
  

}
