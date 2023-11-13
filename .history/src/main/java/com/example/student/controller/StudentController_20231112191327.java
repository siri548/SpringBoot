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

  @GetMapping({ "/list", "/" })

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
  
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		eRepo.save(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
		ModelAndView mav = new ModelAndView("add-employee-form");
		Employee employee = eRepo.findById(employeeId).get();
		mav.addObject("employee", employee);
		return mav;
	}
  
  }
  @GetMapping("/deleteStudent")
  public String deleteStudent(@RequestParam Long Id){
  eRepository.deleteById(Id);
  return "redirect/list";
  }

}
