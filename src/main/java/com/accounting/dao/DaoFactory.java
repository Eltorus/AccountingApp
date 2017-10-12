package com.accounting.dao;

public class DaoFactory {
  private static volatile DaoFactory instance;
  private final EmployeeDao employeeDao = new EmployeeDaoImpl();

  private DaoFactory() {}

  public EmployeeDao getEmployeeDao() {
    return employeeDao;
  }

  public static DaoFactory getInstance() {
    DaoFactory localInstance = instance;
    if (localInstance == null) {
      synchronized (DaoFactory.class) {
        localInstance = instance;
        if (localInstance == null) {
          instance = localInstance = new DaoFactory();
        }
      }
    }
    return localInstance;
  }

}
