package com.accounting.command.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accounting.command.AttributeList;
import com.accounting.command.Command;
import com.accounting.command.EmployeeValidation;
import com.accounting.command.PageList;
import com.accounting.command.ParameterList;
import com.accounting.command.exception.CommandException;
import com.accounting.model.Employee;
import com.accounting.service.EmployeeService;
import com.accounting.service.ServiceFactory;
import com.accounting.service.exception.ServiceException;

public class DeleteUserCommand implements Command {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
    EmployeeService employeeService = ServiceFactory.getInstance().getEmployeeService();

    String email = req.getParameter(ParameterList.EMAIL);
    if(EmployeeValidation.isStringEmpty(email)) {
      return PageList.WRONG_INPUT;
    }
    
    Employee employee = (Employee) req.getSession().getAttribute(AttributeList.ATTR_USER);
    try {
      if (employee.getEmail().equals(email)) {
        employeeService.deleteEmployee(employee);
        req.getSession().invalidate();
        return PageList.SIGN_IN;
      } else if (employee.isAdmin()) {
        Employee processedEmployee = new Employee();
        processedEmployee.setEmail(email);
        employeeService.deleteEmployee(processedEmployee);
        return PageList.ADMIN_PAGE_REDIRECT;
      } else {
        return PageList.WRONG_INPUT;
      }
    } catch (ServiceException e) {
      System.err.println(e);
      throw new CommandException("Error during deleting user", e);
    }
  }

}
