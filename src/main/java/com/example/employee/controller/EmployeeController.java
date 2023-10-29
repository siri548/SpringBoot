package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeRowMapper;
import com.example.employee.service.EmployeeH2Service;

@RestController
public class EmployeeController {

  public EmployeeH2Service employeeService;

  @Autowired
  public EmployeeController(EmployeeH2Service employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public ArrayList<Employee> getEmployees() {
    return employeeService.getEmployees();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
    return employeeService.getEmployeeById(employeeId);
  }

  @PutMapping("/employees/{employeeId}")
  public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
    return employeeService.updateEmployee(employeeId, employee);

  }

  @PostMapping("/employees")
  public Employee addEmployee(Employee employee) {
    return employeeService.addEmployee(employee);
  }

  @DeleteMapping("/employees/{employeeId}")
  public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
    employeeService.deleteEmployee(employeeId);
  }
}

// Write your code here
