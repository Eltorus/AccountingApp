package com.accounting.service;

import java.util.List;
import com.accounting.dao.DaoFactory;
import com.accounting.dao.EmployeeDao;
import com.accounting.dao.exception.DaoException;
import com.accounting.model.Employee;
import com.accounting.service.exception.ServiceException;

public class EmployeeServiceImpl implements EmployeeService {
  
  private EmployeeDao employeeDao = DaoFactory.getInstance().getEmployeeDao();
  
  //TODO: add validation 
  @Override
  public Employee signIn(Employee employee) throws ServiceException {
    try {
      return employeeDao.getEmployeeByEmailAndPswrd(employee);
    } catch (DaoException e) {
      throw new ServiceException("Excpetion during signIn", e);
    }
  }

  @Override
  public boolean signUp(Employee employee) throws ServiceException {
    try {
      return employeeDao.addEmployee(employee);
    } catch (DaoException e) {
      throw new ServiceException("Excpetion during signUp", e);
    }
  }

  @Override
  public boolean updateEmployee(Employee employee) throws ServiceException {
    try {
      return employeeDao.updateEmployee(employee);
    } catch (DaoException e) {
      throw new ServiceException("Excpetion during updateEmployee", e);
    }    
  }

  @Override
  public boolean deleteEmployee(Employee employee) throws ServiceException {
     try {
      return employeeDao.deleteEmployee(employee);
    } catch (DaoException e) {
      throw new ServiceException("Excpetion during deleteEmployee", e);
    }    
  }

  @Override
  public List<Employee> getAllEmployees() throws ServiceException {
    try {
      return employeeDao.getAllEmployees();
    } catch (DaoException e) {
      throw new ServiceException("Excpetion during getAllEmployees", e);
    }
  }
  
  @Override
  public Employee getEmployeeById(Employee employee) throws ServiceException {
    try {
      return employeeDao.getEmployeeById(employee);
    } catch (DaoException e) {
      throw new ServiceException("Excpetion during getEmployeeById", e);
    }
  }
  
/*  public static void main(String[] args) {
    EmployeeService service = new EmployeeServiceImpl();
    Employee employee1 = new Employee();
    employee1.setEmail("Liom@e");
    employee1.setPasswordHash("111");
    employee1.setFullName("John");
    employee1.setPosition("Dev");
    service.signUp(employee1);
    
    Employee employee2 = new Employee();
    employee2.setEmail("zhol@e");
    employee2.setPasswordHash("222");
    employee2.setFullName("Jim");
    employee2.setPosition("Dev");
    service.signUp(employee2);
    
    Employee employee3 = new Employee();
    employee3.setEmail("Liom@e");
    employee3.setPasswordHash("111");
    employee3.setPosition("Dev");
    employee3.setFullName("Faker");
    service.signUp(employee3);
    
    System.out.println(service.signIn(employee1));
    System.out.println(service.signIn(employee2));
  }*/

}
