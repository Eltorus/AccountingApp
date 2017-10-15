package com.accounting.dao;

import java.util.List;
import com.accounting.dao.exception.DaoException;
import com.accounting.model.Employee;

public interface EmployeeDao {
  boolean addEmployee(Employee employee) throws DaoException;

  Employee getEmployeeById(Employee employee) throws DaoException;

  Employee getEmployeeByEmailAndPswrd(Employee employee) throws DaoException;

  List<Employee> getAllEmployees() throws DaoException;

  boolean updateEmployee(Employee employee) throws DaoException;

  boolean deleteEmployee(Employee employee) throws DaoException;
  
}
