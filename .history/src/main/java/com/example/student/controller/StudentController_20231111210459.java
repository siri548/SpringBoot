package com.example.student.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.annotation.Autowired;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.example.student.repository.StudentJpaRepository;
import com.example.student.model.Student;
@RestController
public class StudentController {
@org.springframework.beans.factory.annotation.Autowired
private StudentJpaRepository  eRepository;
  
}