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
    ModelAndView mav = new ModelAndView("StudentApplication");
    List<Student> allStudents = eRepository.findAll();
    mav.addObject("employees", allStudents);
    return mav;
  }
  @GetMapping("/addStudentForm")

  
  public ModelAndView addStudentForm(){
  ModelAndView mav        = new ModelAndView("add-student-form");
  Student      newstudent = new Student();
  mav.addObject("student", newstudent);
  return mav;
  }
  @PostMapping("/saveStudent")
  public String saveStudent(@ModelAttribute Student student){
  eRepository.save(student);
  return "redirect/list";
  }
  @GetMapping("/showUpdateFrom")
  public ModelAndView showUpdateForm(@RequestParam long Id){
  ModelAndView mav     = new ModelAndView("add-student-form");
  Student      student = eRepository.findById(studentId).get();
  mav.addObject("student", student);
  return mav;
  
  }
  @GetMapping("/deleteStudent")
  public String deleteStudent(@RequestParam Long Id){
  eRepository.deleteById(stuId);
  return "redirect/list";
  }

}
