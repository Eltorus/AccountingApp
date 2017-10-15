package com.accounting.service;

import java.util.List;
import com.accounting.model.Employee;
import com.accounting.service.exception.ServiceException;

public interface EmployeeService {
  Employee signIn(Employee employee) throws ServiceException;

  boolean signUp(Employee employee) throws ServiceException;
  
  Employee getEmployeeById(Employee employee) throws ServiceException;

  boolean updateEmployee(Employee employee) throws ServiceException;

  boolean deleteEmployee(Employee employee) throws ServiceException;
  
  List<Employee> getAllEmployees() throws ServiceException;

}
