// Write your code here
package com.example.employee.repository;

import java.util.*;
import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeRowMapper;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();

    Employee getEmployeeById(int employeeId);

    Employee updateEmployee(int employeeId, Employee employee);

    Employee addEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
