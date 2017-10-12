package com.accounting.service;

import java.util.List;
import com.accounting.dao.DaoFactory;
import com.accounting.dao.EmployeeDao;
import com.accounting.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
  
  private EmployeeDao employeeDao = DaoFactory.getInstance().getEmployeeDao();
  
  @Override
  public Employee signIn(Employee employee) {
    return employeeDao.getEmployeeByEmailAndPswrd(employee);
  }

  @Override
  public boolean signUp(Employee employee) {
    return employeeDao.addEmployee(employee);
  }

  @Override
  public void updateEmployee(Employee employee) {
    employeeDao.updateEmployee(employee);    
  }

  @Override
  public void deleteEmployee(Employee employee) {
     employeeDao.deleteEmployee(employee);    
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeDao.getAllEmployees();
  }
  
  public static void main(String[] args) {
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
  }

  @Override
  public void deleteEmployeeByEmail(Employee employee) {
    employeeDao.deleteEmployeeByEmail(employee);
  }

  @Override
  public Employee getEmployeeById(Employee employee) {
    return employeeDao.getEmployeeById(employee);
  }

}
