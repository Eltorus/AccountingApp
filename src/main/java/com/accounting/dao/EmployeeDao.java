package com.accounting.dao;

import java.util.List;
import com.accounting.model.Employee;

public interface EmployeeDao {
  boolean addEmployee(Employee employee);

  Employee getEmployeeById(Employee employee);
  
  Employee getEmployeeByEmailAndPswrd(Employee employee);
  
  List<Employee> getAllEmployees();

  void updateEmployee(Employee employee);

  void deleteEmployee(Employee employee);
  
  void deleteEmployeeByEmail(Employee employee);
}
