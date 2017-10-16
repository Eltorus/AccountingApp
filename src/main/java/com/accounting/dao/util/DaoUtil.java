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
  
  private DaoUtil() throws DaoException {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      DBResourceManager resourceManager = DBResourceManager.getInstance();
      this.url = resourceManager.getValue(DBParameter.DB_URL);
      this.password = resourceManager.getValue(DBParameter.DB_PASSWORD);
      this.login = resourceManager.getValue(DBParameter.DB_LOGIN);
    } catch (SQLException e) {
      throw new DaoException("Exception during registering driver", e);
    }
  }
  
  public static DaoUtil getInstance() throws DaoException {
    DaoUtil localInstance = instance;
    if(localInstance == null) {
      synchronized (DaoUtil.class) {
        localInstance = instance;
        if(localInstance == null) {
          instance = localInstance= new DaoUtil();
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

