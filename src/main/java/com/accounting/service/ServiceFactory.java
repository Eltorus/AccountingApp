package com.accounting.service;

public class ServiceFactory {
  private static volatile ServiceFactory instance;

  private ServiceFactory() {}

  private final EmployeeService employeeService = new EmployeeServiceImpl();
  
  public EmployeeService getEmployeeService() {
    return employeeService;
  }
  
  public static ServiceFactory getInstance() {
    ServiceFactory localInstance = instance;
    if (localInstance == null) {
      synchronized (ServiceFactory.class) {
        localInstance = instance;
        if (localInstance == null) {
          instance = localInstance = new ServiceFactory();
        }
      }
    }
    return localInstance;
  }
}
