package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import com.example.student.model.Student;
import com.example.student.repository.StudentJpaRepository;
import java.util.*;
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
  }
  @GetMapping("/addStudentForm")
  public ModelAndView addStudentForm(){
  ModelAndView mav = new ModelAndView();
  Student newstudent =new Student()
  }
  @PostMapping("/saveStudent")
  public String saveStudent(@ModelAttribute Student student){
  eRepository.save(student);
  return "redirect:/list";
}

}
