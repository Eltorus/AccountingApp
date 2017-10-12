package com.accounting.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import com.accounting.model.Employee;
import com.accounting.util.HashTool;
import com.accounting.util.exception.UtilException;

public class EmployeeValidation {
  public static boolean isEmailAndPswrdValid(Employee employee) {
    if (employee == null) {
      return false;
    }

    return !(Validation.isStringEmpty(employee.getEmail())
        || Validation.isStringEmpty(employee.getPasswordHash()));
  }
  
  public static boolean isEmailValid(String email) {
    return !(Validation.isStringEmpty(email) || email.trim().length() > 45
        || email.trim().length() < 8);
  }
  
  public static Employee isEmployeeValid(HttpServletRequest req) throws UtilException {
    String passwordConfirm = req.getParameter(ParameterList.PSWRD_CONFIRM);
    String password = req.getParameter(ParameterList.PSWRD);
    if (!passwordConfirm.equals(password)) {
      return null;
    }

    String name = req.getParameter(ParameterList.NAME);
    if (name == null || name.trim().isEmpty() || name.length() > 50) {
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
    if (!isEmailValid(email) || emailMatcher.find()) {
      return null;
    }
    
    //TODO: в другой метод
    Employee employee = new Employee();
    employee.setFullName(name.trim());
    employee.setEmail(email.trim());
    employee.setPasswordHash(HashTool.hashLine(password));
    return employee;
  }
  
  
}
