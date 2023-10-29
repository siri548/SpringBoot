package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeRowMapper;

import javax.validation.OverridesAttribute;

import com.example.employee.repository.EmployeeRepository;

// Write your code here
@Service
public class EmployeeH2Service implements EmployeeRepository {
    @Autowired

    private JdbcTemplate db;

    @Override
    public ArrayList<Employee> getEmployees() {
        Collection<Employee> employeesList = db.query("select * from employeelist", new EmployeeRowMapper());
        ArrayList<Employee> employees = new ArrayList<>(employeesList);
        return employees;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        try {
            Employee employee = db.queryForObject("select * from employeelist where employeeId=?",
                    new EmployeeRowMapper(), employeeId);
            return employee;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        db.update("INSERT INTO employeelist(employeeId,employeeName, email, department) VALUES (?,?,?,?)",
                employee.getEmployeeId(),
                employee.getEmployeeName(), employee.getEmail(), employee.getDepartment());
        Employee newEmployee = db.queryForObject(
                "select * from employeelist where employeeId=? and employeeName=? and email=? and department=?",
                new EmployeeRowMapper(), employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmail(),
                employee.getDepartment());
        return newEmployee;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        if (employee.getEmployeeName() != null) {
            db.update("update employeelist SET employeeName=? where employeeId=?", employee.getEmployeeName(),
                    employeeId);
        }
        if (employee.getEmail() != null) {
            db.update("update employeelist SET email=? where employeeId=?", employee.getEmail(), employeeId);
        }
        if (employee.getDepartment() != null) {
            db.update("update employeelist SET department=? where employeeId=?", employee.getDepartment(), employeeId);
        }
        return getEmployeeById(employeeId);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        db.update("delete from employeelist where employeeId=?", employeeId);
    }
}