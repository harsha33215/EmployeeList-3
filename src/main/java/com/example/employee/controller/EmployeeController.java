/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class EmployeeController {
  @Autowired
  private EmployeeJpaService employeeJpaService;

  @GetMapping("/employees")
  public ArrayList<Employee> getAllEmployees() {
    return employeeJpaService.getAllEmployees();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
    return employeeJpaService.getEmployeeById(employeeId);
  }

  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee employee) {
    return employeeJpaService.addEmployee(employee);
  }

  @PutMapping("employees/{employeeId}")
  public Employee updatEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
    return employeeJpaService.updateEmployee(employeeId, employee);
  }

  @DeleteMapping("employees/{employeeId}")
  public void deleteEmployee(@PathVariable("employeeId") int employeeId) {
    employeeJpaService.deleteEmployee(employeeId);
  }
}
