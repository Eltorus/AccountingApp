package com.accounting.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.accounting.dao.exception.DaoException;

public class DaoUtil {
  
  private String url;
  private String password;
  private String login;

  private static volatile DaoUtil instance;
  
  private DaoUtil() {}

  private static void init() throws DaoException {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    } catch (SQLException e) {
      throw new DaoException("Exception during init method", e);
    }
    
  }
  
  public static DaoUtil getInstance() throws DaoException {
    DaoUtil localInstance = instance;
    if(localInstance == null) {
      synchronized (DaoUtil.class) {
        localInstance = instance;
        if(localInstance == null) {
          instance = localInstance= new DaoUtil();
          init();
        }
      }
    }
    return localInstance;
  }
  
  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, login, password);
  }
  
  public void closeConnection(Connection con, Statement st) throws DaoException {
    try {
      if (con != null) {
        if (st != null) {
          st.close();
        }
        con.close();
      }
    } catch (SQLException e) {
      throw new DaoException("Exception during closing connection",e);
    }
  }
}

