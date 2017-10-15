package com.accounting.command.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accounting.command.AttributeList;
import com.accounting.command.Command;
import com.accounting.command.EmployeeValidation;
import com.accounting.command.PageList;
import com.accounting.command.exception.CommandException;
import com.accounting.model.Employee;
import com.accounting.service.EmployeeService;
import com.accounting.service.ServiceFactory;
import com.accounting.service.exception.ServiceException;
import com.accounting.util.exception.UtilException;

public class SignUpCommand implements Command {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
    try {
      Employee employee = EmployeeValidation.isEmployeeValid(req);
      if (employee != null) {
        EmployeeService employeeService = ServiceFactory.getInstance().getEmployeeService();
        if (employeeService.signUp(employee)) {
          System.err.println(employee);
          req.getSession().setAttribute(AttributeList.ATTR_USER, employee);
          return PageList.PROFILE;
        }
      } 
        return PageList.WRONG_INPUT;
    } catch (UtilException | ServiceException e) {
      // TODO: logging
      return PageList.ERROR;
    }
  }
}
