package com.accounting.command;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import com.accounting.model.Employee;
import com.accounting.util.DateUtil;
import com.accounting.util.HashTool;
import com.accounting.util.exception.UtilException;

public class EmployeeValidation {
  public static boolean isEmailAndPswrdValid(Employee employee) {
    return !(employee == null || isStringEmpty(employee.getEmail())
        || isStringEmpty(employee.getPasswordHash()));
  }

  public static boolean isEmailValid(String email) {
    return !(email == null || email.trim().isEmpty() || email.trim().length() > 45
        || email.trim().length() < 8);
  }

  public static boolean isStringEmpty(String line) {
    return line == null || line.isEmpty();
  }

  public static Employee isEmployeeValid(HttpServletRequest req) throws UtilException {
    String password = req.getParameter(ParameterList.PSWRD);
    String passwordConfirm = req.getParameter(ParameterList.PSWRD_CONFIRM);
    if (isStringEmpty(password) || password.trim().length() < 5
        || !password.equals(passwordConfirm)) {
      return null;
    }

    String name = req.getParameter(ParameterList.NAME);
    if (isStringEmpty(name) || name.trim().length() > 40) {
      return null;
    }

    Pattern namePattern = Pattern.compile("^\\w+$");
    Matcher nameMatcher = namePattern.matcher(name.trim());
    if (!nameMatcher.find()) {
      return null;
    }

    String email = req.getParameter(ParameterList.EMAIL);
    Pattern emailPattern = Pattern.compile("^(.[^@\\s]+)@(.[^@\\s]+)\\.([a-z]+)$");
    Matcher emailMatcher = emailPattern.matcher(email.trim());
    if (!isEmailValid(email) || !emailMatcher.find()) {
      return null;
    }

    String birthDate = req.getParameter(ParameterList.BIRTH_DATE);
    if (isStringEmpty(birthDate) || birthDate.trim().length() > 10) {
      return null;
    }

    Date birth = DateUtil.getDateRusFormat(birthDate);
    if (birth.after(new Date())) {
      return null;
    }

    String position = req.getParameter(ParameterList.POSITION);
    if (isStringEmpty(position) || position.trim().length() > 25) {
      return null;
    }

    String homeAddress = req.getParameter(ParameterList.HOME_ADDRESS);
    if (isStringEmpty(homeAddress) || homeAddress.trim().length() > 40) {
      return null;
    }

    Employee employee = new Employee(email.trim(), HashTool.hashLine(password.trim()), name, birth,
        position.trim());
    employee.setHomeAddress(homeAddress.trim());
    return employee;
  }

}
