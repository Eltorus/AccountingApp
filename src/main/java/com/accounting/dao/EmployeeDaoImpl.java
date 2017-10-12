package com.accounting.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import com.accounting.dao.util.HibernateUtil;
import com.accounting.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

  private EntityManager em = HibernateUtil.getEntityManager();

  @Override
  public boolean addEmployee(Employee employee) {
    em.getTransaction().begin();
    try {
      Employee result = (Employee) em.createQuery("SELECT e from Employee e WHERE email = :email")
          .setParameter("email", employee.getEmail()).getSingleResult();
      
      if (employee.getEmail().equals(result.getEmail())) {
        return false;
      } else {
        em.persist(employee);
      }
    } catch (NoResultException nre) {
      em.persist(employee);
    }
    em.getTransaction().commit();
    return true;
  }

  @Override
  public Employee getEmployeeById(Employee employee) {
    return em.find(Employee.class, employee);
  }

  @Override
  public void updateEmployee(Employee employee) {
    em.getTransaction().begin();
    em.refresh(employee);
    em.getTransaction().commit();
  }

  @Override
  public void deleteEmployee(Employee employee) {
    em.getTransaction().begin();
    em.remove(employee);
    em.getTransaction().begin();
  }

  @Override
  public List<Employee> getAllEmployees() {
    return em.createQuery("select e from Employee e", Employee.class).getResultList();
  }

  @Override
  public Employee getEmployeeByEmailAndPswrd(Employee employee) {
    return (Employee) em
        .createQuery("SELECT e from Employee e WHERE email = :email AND password = :password")
        .setParameter("email", employee.getEmail())
        .setParameter("password", employee.getPasswordHash()).getSingleResult();
  }

  @Override
  public void deleteEmployeeByEmail(Employee employee) {
    em.getTransaction().begin();
    em.createQuery("DELETE e from Employee e WHERE email = :email")
    .setParameter("email", employee.getEmail()).executeUpdate();
    em.getTransaction().begin();
  }

}
