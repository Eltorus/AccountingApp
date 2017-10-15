package com.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.accounting.dao.exception.DaoException;
import com.accounting.dao.util.DaoUtil;
import com.accounting.model.Employee;
import com.accounting.util.DateUtil;
import com.accounting.util.exception.UtilException;

public class EmployeeDaoImpl implements EmployeeDao {

  @Override
  public boolean addEmployee(Employee employee) throws DaoException {
    Connection con = null;
    PreparedStatement ps = null;
    DaoUtil daoUtil = DaoUtil.getInstance();
    try {
      con = daoUtil.getConnection();
      ps = con.prepareStatement(QueryList.INSERT_EMPLOYEE);
      ps.setString(1, employee.getEmail());
      ps.setString(2, employee.getPasswordHash());
      ps.setString(3, employee.getFullName());
      ps.setString(4, DateUtil.convertDateToString(employee.getBirth()));
      ps.setString(5, employee.getPosition());
      ps.setString(6, employee.getHomeAddress());
      return ps.executeUpdate() != 0;
    } catch (SQLException e) {
      throw new DaoException("Exception during adding employee", e);
    } finally {
      daoUtil.closeConnection(con, ps);
    }
  }

  @Override
  public Employee getEmployeeById(Employee employee) throws DaoException{
    Employee result = null;
    Connection con = null;
    PreparedStatement ps = null;
    DaoUtil daoUtil = DaoUtil.getInstance();
    try {
      con = daoUtil.getConnection();
      ps = con.prepareStatement(QueryList.SELECT_BY_ID);
      ps.setLong(1, employee.getId());
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        result = getQueryResult(rs);
      }
    } catch (SQLException | UtilException e) {
      throw new DaoException("Exception during adding employee", e);
    } finally {
      daoUtil.closeConnection(con, ps);
    }
    return result;
  }

  @Override
  public boolean updateEmployee(Employee employee) throws DaoException {
    Connection con = null;
    PreparedStatement ps = null;
    DaoUtil daoUtil = DaoUtil.getInstance();
    try {
      con = daoUtil.getConnection();
      ps = con.prepareStatement(QueryList.UPDATE_EMPLOYEE);
      ps.setString(1, employee.getPosition());
      ps.setString(2, employee.getHomeAddress());
      ps.setBoolean(3, employee.isAdmin());
      ps.setString(4, employee.getEmail());
      return ps.executeUpdate() != 0;
    } catch (SQLException e) {
      throw new DaoException("Exception during adding employee", e);
    } finally {
      daoUtil.closeConnection(con, ps);
    }
  }

  @Override
  public boolean deleteEmployee(Employee employee) throws DaoException {
    Connection con = null;
    PreparedStatement ps = null;
    DaoUtil daoUtil = DaoUtil.getInstance();
    try {
      con = daoUtil.getConnection();
      ps = con.prepareStatement(QueryList.UPDATE_EMPLOYEE);
      ps.setString(1, employee.getEmail());
      return ps.executeUpdate() != 0;
    } catch (SQLException e) {
      throw new DaoException("Exception during adding employee", e);
    } finally {
      daoUtil.closeConnection(con, ps);
    }
  }

  @Override
  public List<Employee> getAllEmployees() throws DaoException {
    List<Employee> result = null;
    Connection con = null;
    PreparedStatement ps = null;
    DaoUtil daoUtil = DaoUtil.getInstance();
    try {
      con = daoUtil.getConnection();
      ps = con.prepareStatement(QueryList.SELECT_ALL_EMPLOYEES);
      ResultSet rs = ps.executeQuery();
      result = new ArrayList<>();
      while(rs.next()) {
        result.add(getQueryResult(rs));
      }
    } catch (SQLException | UtilException e) {
      throw new DaoException("Exception during adding employee", e);
    } finally {
      daoUtil.closeConnection(con, ps);
    }
    return result;
  }

  @Override
  public Employee getEmployeeByEmailAndPswrd(Employee employee) throws DaoException {
    Employee result = null;
    Connection con = null;
    PreparedStatement ps = null;
    DaoUtil daoUtil = DaoUtil.getInstance();
    try {
      con = daoUtil.getConnection();
      ps = con.prepareStatement(QueryList.SELECT_BY_EMAIL_AND_PSWRD);
      ps.setString(1, employee.getEmail());
      ps.setString(1, employee.getPasswordHash());
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        result = getQueryResult(rs);
      }
    } catch (SQLException | UtilException e) {
      throw new DaoException("Exception during adding employee", e);
    } finally {
      daoUtil.closeConnection(con, ps);
    }
    return result;
  }

  
  private Employee getQueryResult(ResultSet rs) throws SQLException, UtilException {
    Employee employee = new Employee();
    employee.setId(rs.getLong(1));
    employee.setEmail(rs.getString(2));
    employee.setPasswordHash(rs.getString(3));
    employee.setFullName(rs.getString(4));
    employee.setBirth(DateUtil.convertStringToDate(rs.getString(5)));
    employee.setPosition(rs.getString(6));
    employee.setExperience(DateUtil.getTimePastFromDate(rs.getString(7)));
    employee.setHomeAddress(rs.getString(8));
    employee.setAdmin(rs.getBoolean(9));
    
    return employee;
  }

}
