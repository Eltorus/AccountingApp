package com.accounting.dao;

public class QueryList {
  public static final String INSERT_EMPLOYEE = "INSERT IGNORE INTO accounting.employees "
      + "(`id`, `email`,`password`, `full_name`, `birth`, `position`, `registration_date`, `home_address`) "
      + "VALUES (DEFAULT, ?, ?, ?, ?, ?, now(), ?)";

  public static final String SELECT_BY_ID =
      "SELECT `id`, `email`,`password`, `full_name`, `birth`, `position`, `registration_date`, `home_address`, `admin` "
          + "FROM accounting.employees " 
          + "WHERE `id` = ? AND AND deleted=false";

  public static final String SELECT_BY_EMAIL_AND_PSWRD =
      "SELECT `id`, `email`,`password`, `full_name`, `birth`, `position`, `registration_date`, `home_address`,`admin` "
          + "FROM accounting.employees "
          + "WHERE `email` = ? AND `password` = ? AND deleted=false";

  public static final String UPDATE_EMPLOYEE =
      "UPDATE accounting.employees SET `position`=?, `home_address`=?, `admin`=? WHERE `email` =? AND deleted=false ";

  public static final String DELETE_EMPLOYEE =
      "UPDATE accounting.employees "
      + "SET `deleted`=true "
      + "WHERE `email`=?";
  
  public static final String SELECT_ALL_EMPLOYEES =
      "SELECT `id`, `email`,`password`, `full_name`, `birth`, `position`, `registration_date`, `home_address`, `admin`"
    + "FROM accounting.employees";

}
