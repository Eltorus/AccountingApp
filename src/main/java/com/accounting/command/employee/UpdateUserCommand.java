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

public class UpdateUserCommand implements Command {

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
    String email = req.getParameter(ParameterList.EMAIL);
    if (EmployeeValidation.isStringEmpty(email)) {
      return PageList.WRONG_INPUT;
    }

    Employee employee = (Employee) req.getSession().getAttribute(AttributeList.ATTR_USER);
    EmployeeService employeeService = ServiceFactory.getInstance().getEmployeeService();
    try {
      if (email.equals(employee.getEmail())) {
        String homeAddress = req.getParameter(ParameterList.HOME_ADDRESS);
        if (EmployeeValidation.isStringEmpty(homeAddress)) {
          return PageList.WRONG_INPUT;
        }
        
        employee.setHomeAddress(homeAddress);
        employeeService.updateEmployee(employee);
        req.getSession().setAttribute(AttributeList.ATTR_USER, employee);
        return PageList.PROFILE;
      } else if (employee.isAdmin()) {
        Employee processedEmployee = new Employee();
        processedEmployee.setEmail(email);
        processedEmployee = employeeService.getEmployeeByEmail(processedEmployee);
        String position = req.getParameter(ParameterList.POSITION);
        processedEmployee.setPosition(position);

        String admin = req.getParameter(ParameterList.ADMIN);
        if (admin.equals("1")) {
          processedEmployee.setAdmin(true);
        } else {
          processedEmployee.setAdmin(false);
        }

        employeeService.updateEmployee(processedEmployee);
        return PageList.ADMIN_PAGE_REDIRECT;
      } else {
        return PageList.WRONG_INPUT;
      }
    } catch (ServiceException e) {
      System.err.println(e);
      throw new CommandException("Error during updating user", e);
    }
  }

}
