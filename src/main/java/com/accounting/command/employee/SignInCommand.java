package com.accounting.command.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.accounting.command.AttributeList;
import com.accounting.command.Command;
import com.accounting.command.EmployeeValidation;
import com.accounting.command.PageList;
import com.accounting.command.ParameterList;
import com.accounting.command.exception.CommandException;
import com.accounting.model.Employee;
import com.accounting.service.EmployeeService;
import com.accounting.service.ServiceFactory;
import com.accounting.util.HashTool;
import com.accounting.util.exception.UtilException;

public class SignInCommand implements Command {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
    String email = req.getParameter(ParameterList.EMAIL);
    String password = req.getParameter(ParameterList.PSWRD);

    try {
      Employee employee = new Employee();
      employee.setEmail(email);
      employee.setPasswordHash(HashTool.hashLine(password));

      if (EmployeeValidation.isEmailAndPswrdValid(employee)) {
        return PageList.WRONG_INPUT;
      }

      EmployeeService employeeService = ServiceFactory.getInstance().getEmployeeService();
      employee = employeeService.signIn(employee);

      HttpSession session = req.getSession();
      if (employee != null) {
        session.setAttribute(AttributeList.ATTR_USER, employee);
      } else {
        session.setAttribute("error", "Wrong login or password");
      }
      
      return PageList.SIGN_IN;
    } catch (UtilException e) {
      // TODO: add logging
      return PageList.ERROR;
    }
  }

}
