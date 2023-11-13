package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.student.repository.StudentJpaRepository;

@RestController
public class StudentController {
  @Autowired
  private StudentJpaRepository eRepository;

  @GetMapping({ "/List", "/" })

  public ModelAndView getAllStudents() {
    ModelAndView mav = new ModelAndView("list-employees");
    List<Student> allStudents = eRepository.findAll();
    mav.addObject("employees", allStudents);
    return mav;
  }@PostMapping("/saveStudent")
  public String saveStudent(@Mode)

}