package com.accounting.service;

import java.util.List;
import com.accounting.model.Employee;

public interface EmployeeService {
  Employee signIn(Employee employee);

  boolean signUp(Employee employee);
  
  Employee getEmployeeById(Employee employee);

  void updateEmployee(Employee employee);

  void deleteEmployee(Employee employee);
  
  List<Employee> getAllEmployees();
  
  void deleteEmployeeByEmail(Employee employee);
}
